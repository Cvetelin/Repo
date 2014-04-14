package bg.ceco.demo.springmvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javassist.CtClass;
import javassist.CtMethod;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bg.ceco.demo.logic.ClassInfoService;
import bg.ceco.demo.logic.ExecInfoService;
import bg.ceco.demo.logic.ProjectService;
import bg.ceco.demo.logic.TestInfoService;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.TestInfo;

@Controller
public class ProjectController {
	private static final String JAR_SAVE_LOCATION = "bugshot-tmp\\";
	@Autowired
	private ProjectService projectService;

	@Autowired
	private ClassInfoService classInfoService;

	@Autowired
	private TestInfoService testInfoService;

	@Autowired
	public ExecInfoService execInfoService;

	@RequestMapping(value = "/ShowProjects", method = RequestMethod.GET)
	public ModelAndView showProjects() {
		ModelMap map = new ModelMap();
		map.addAttribute("projects", projectService.list());
		return new ModelAndView("ShowProjects", map);
	}

	@RequestMapping(value = "/EditProject", method = RequestMethod.GET)
	public ModelAndView editProject(@RequestParam("id") long id, @ModelAttribute("projectForm") ProjectForm projectForm) {
		Project project = projectService.load(id);
		projectForm.setName(project.getProjectName());
		projectForm.setProjectId(String.valueOf(id));
		if (!StringUtils.isEmpty(project.getDescription())) {
			projectForm.setDescription(project.getDescription());
		}
		ModelMap map = new ModelMap();
		map.addAttribute("project", projectForm);
		return new ModelAndView("AddProject", map);
	}

	@RequestMapping(value = "/AddProject", method = RequestMethod.GET)
	public String showAdd(@ModelAttribute ProjectForm projectForm, BindingResult result) {
		return "AddProject";
	}

	@RequestMapping(value = "/CreateProject", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("projectForm") ProjectForm projectForm, BindingResult result,
			@RequestParam("testJar") MultipartFile testJar, @RequestParam("depJar") MultipartFile depJar) {
		FileValidator fileValidator = new FileValidator();
		fileValidator.validate(testJar, result);
		try {
			if (!StringUtils.isBlank(projectForm.getProjectId()) && projectService.load(Long.valueOf(projectForm.getProjectId())) != null) {
				Project existingProject = projectService.load(Long.valueOf(projectForm.getProjectId()));

				String depJarPath = constructSaveLocation(projectForm, depJar);
				String testJarPatj = constructSaveLocation(projectForm, testJar);
				existingProject.setDateModification(new Date());
				existingProject.setDependencyJar(depJar.getBytes());
				existingProject.setDependencyJarName(depJar.getOriginalFilename());
				existingProject.setDependencyJarPath(depJarPath);
				existingProject.setDescription(projectForm.getDescription());
				existingProject.setJarName(testJar.getOriginalFilename());
				existingProject.setJarPath(testJarPatj);
				existingProject.setProjectName(projectForm.getName());
				existingProject.setTestJar(testJar.getBytes());
				projectService.update(existingProject);
				return new ModelAndView("redirect:/app/ShowProjects");
			}
			Project project = new Project();
			// if (!(depJar.getSize() == 0)) {
			// fileValidator.validate(depJar, result);
			// }

			String depJarPath = constructSaveLocation(projectForm, depJar);
			String testJarPatj = constructSaveLocation(projectForm, testJar);
			project.setDateCreation(new Date());
			project.setDependencyJar(depJar.getBytes());
			project.setDependencyJarName(depJar.getOriginalFilename());
			project.setDependencyJarPath(depJarPath);
			project.setDescription(projectForm.getDescription());
			project.setJarName(testJar.getOriginalFilename());
			project.setJarPath(testJarPatj);
			project.setProjectName(projectForm.getName());
			project.setTestJar(testJar.getBytes());
			projectService.save(project);
			// Blob b = lh.createBlob(file.getInputStream(), file.);
			// byte[] bytes = testJar.getBytes();
			// BufferedOutputStream stream =
			// new BufferedOutputStream(new FileOutputStream(new File(name +
			// "-uploaded")));
			// stream.write(bytes);
			// stream.close();
			return new ModelAndView("redirect:/app/ShowProjects");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("AddProject");

		}
	}

	@RequestMapping(value = "/GenerateTree", method = RequestMethod.GET)
	public ModelAndView generate(@RequestParam("id") long id) throws Exception {
		Project project = projectService.load(id);
		ProjectTreeGenerator generator = new ProjectTreeGenerator();
		List<CtClass> classes = generator.loadJar(project);
		clearOldData(project);
		generateClassSturcture(classes, project);
		ModelMap map = new ModelMap();
		map = listPorejectDetils(project);
		return new ModelAndView("ShowProjectDetails", map);
	}

	@RequestMapping(value = "/ShowProjectDetails", method = RequestMethod.GET)
	public ModelAndView projectDetails(@RequestParam("id") long id) {
		Project project = projectService.load(id);
		ModelMap projectDetails = listPorejectDetils(project);
		return new ModelAndView("ShowProjectDetails", projectDetails);
	}

	private String constructSaveLocation(ProjectForm projectForm, MultipartFile file) {
		String rootDir = "C:\\";
		StringBuilder path = new StringBuilder();

		path.append(rootDir);
		path.append(JAR_SAVE_LOCATION);
		path.append(projectForm.getName());
		path.append("\\");
		path.append(file.getOriginalFilename());
		path.append("-");
		path.append(RandomStringUtils.randomNumeric(4));
		path.append("\\");
		path.append(file.getOriginalFilename());
		return path.toString();
	}

	private void generateClassSturcture(List<CtClass> classes, Project project) throws Exception {

		List<ClassInfo> classInfos = new ArrayList<ClassInfo>();
		List<TestInfo> testInfos = new ArrayList<TestInfo>();
		for (CtClass class1 : classes) {
			CtMethod[] methods = class1.getDeclaredMethods();
			ClassInfo classInfo = new ClassInfo();

			classInfo.setName(class1.getSimpleName());
			classInfo.setQualifiedName(class1.getName());
			classInfo.setProject(project);
			classInfos.add(classInfo);

			classInfoService.save(classInfo);

			for (int i = 0; i < methods.length; i++) {
				TestInfo testInfo = new TestInfo();
				testInfo.setName(methods[i].getName());
				testInfo.setClassInfo(classInfoService.loadBy(project, class1.getName()));
				testInfos.add(testInfo);
			}
			testInfoService.saveAll(testInfos);
		}
	}

	private void clearOldData(Project project) {
		List<ClassInfo> classSet = classInfoService.listBy(project);
		try {
			for (Iterator classIterator = classSet.iterator(); classIterator.hasNext();) {
				ClassInfo classInfo = (ClassInfo) classIterator.next();
				// List<TestInfo> testSet = testInfoService.listBy(classInfo);
				// for (Iterator testIteretor = testSet.iterator();
				// testIteretor.hasNext();) {
				// TestInfo testInfo = (TestInfo) testIteretor.next();
				// List<ExecInfo> execSet = execInfoService.listBy(testInfo);
				// for (Iterator execIterator = execSet.iterator();
				// execIterator.hasNext();) {
				// ExecInfo execInfo = (ExecInfo) execIterator.next();
				// execInfoService.delete(execInfo);
				// }
				// testInfoService.delete(testInfo);
				// }
				classInfoService.delete(classInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ModelMap listPorejectDetils(Project project) {
		ModelMap projectDetails = new ModelMap();
		projectDetails.addAttribute("project", project);
		List<ClassInfo> classes = classInfoService.listBy(project);
		projectDetails.addAttribute("classInfos", classes);
		Collection<TestInfo> methods = new ArrayList<TestInfo>();
		for (Iterator iterator = classes.iterator(); iterator.hasNext();) {
			ClassInfo classInfo = (ClassInfo) iterator.next();
			methods.addAll(testInfoService.listBy(classInfo));
		}
		projectDetails.addAttribute("testInfos", methods);
		projectDetails.addAttribute("projectsList", projectService.list());
		return projectDetails;
	}
}
