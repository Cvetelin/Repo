package bg.ceco.demo.springmvc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javassist.CtClass;
import javassist.CtMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import bg.ceco.demo.model.ExecInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.TestInfo;
import bg.ceco.demo.springmvc.beans.ManageProjectBean;
import bg.ceco.demo.springmvc.beans.TestInfoBean;

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
	private ExecInfoService execInfoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelMap map = new ModelMap();
		map.addAttribute("projects", projectService.list());
		return new ModelAndView("index");
	}

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
	@Scope(value = "request")
	public ModelAndView addOrModify(@ModelAttribute("projectForm") ProjectForm projectForm, BindingResult result,
			@RequestParam("testJar") MultipartFile testJar) throws Exception {
		// @RequestParam("depJar") MultipartFile depJar) {
		if (!StringUtils.isBlank(projectForm.getProjectId()) && projectService.load(Long.valueOf(projectForm.getProjectId())) != null) {
			Project existingProject = projectService.load(Long.valueOf(projectForm.getProjectId()));
			String testJarPatj = constructSaveLocation(projectForm, testJar);
			existingProject.setDateModification(new Date());

			existingProject.setDescription(projectForm.getDescription());
			existingProject.setJarName(testJar.getOriginalFilename());
			existingProject.setJarPath(testJarPatj);
			existingProject.setProjectName(projectForm.getName());
			existingProject.setTestJar(testJar.getBytes());
			projectService.update(existingProject);
			return new ModelAndView("redirect:/ShowProjects");
		}
		Project project = new Project();
		String testJarPatj = constructSaveLocation(projectForm, testJar);
		project.setDateCreation(new Date());
		project.setDescription(projectForm.getDescription());
		project.setJarName(testJar.getOriginalFilename());
		project.setJarPath(testJarPatj);
		project.setProjectName(projectForm.getName());
		project.setTestJar(testJar.getBytes());
		projectService.save(project);

		ProjectTreeGenerator generator = new ProjectTreeGenerator();
		List<CtClass> classes = generator.readJar(project);
		generateClassStructure(classes, project);

		return new ModelAndView("redirect:/ShowProjects");
	}

	@RequestMapping(value = "/Generate", method = RequestMethod.GET)
	public ModelAndView generate(@RequestParam("id") long id) throws Exception {
		Project project = projectService.load(id);
		ProjectTreeGenerator generator = new ProjectTreeGenerator();
		clearOldData(project);
		List<CtClass> classes = generator.readJar(project);
		generateClassStructure(classes, project);

		ModelMap map = listPorejectDetils(project);
		return new ModelAndView("ShowProjectDetails", map);
	}

	@RequestMapping(value = "/ShowProjectDetails", method = RequestMethod.GET)
	public ModelAndView projectDetails(@RequestParam("id") long id) {
		Project project = projectService.load(id);
		ModelMap projectDetails = listPorejectDetils(project);
		return new ModelAndView("ShowProjectDetails", projectDetails);
	}

	@RequestMapping(value = "/ManageProject", method = RequestMethod.GET)
	public ModelAndView manageProject(@RequestParam("id") long id) {
		Project project = projectService.load(id);
		ModelMap projectDetails = new ModelMap();
		projectDetails.addAttribute("project", project);
		List<ClassInfo> classes = classInfoService.listBy(project);
		Collection<ManageProjectBean> manageProjectBeans = new ArrayList<ManageProjectBean>();
		for (ClassInfo classInfo : classes) {
			ManageProjectBean manageProjectBean = new ManageProjectBean();
			Collection<TestInfoBean> testInfoBeans = new ArrayList<TestInfoBean>();
			for (TestInfo testInfo : testInfoService.listBy(classInfo)) {
				TestInfoBean testInfoBean = new TestInfoBean();

				manageProjectBean.setClassId(classInfo.getId());
				manageProjectBean.setClassName(classInfo.getName());
				testInfoBean.setName(testInfo.getName());
				testInfoBean.setId(testInfo.getId());

				ExecInfo execInfo = execInfoService.getlastExecution(testInfo);
				if (execInfo != null) {
					testInfoBean.setExecutionDate(execInfo.getExecutionDate());
					testInfoBean.setLastRunStatus(execInfo.isStatus());
					testInfoBean.setNumberOfExections(execInfoService.listBy(testInfo).size());
				}

				testInfoBeans.add(testInfoBean);
				manageProjectBean.setTestBeans(testInfoBeans);
			}
			manageProjectBeans.add(manageProjectBean);
		}
		projectDetails.addAttribute("manageProject", manageProjectBeans);
		projectDetails.addAttribute("projectsList", projectService.list());

		return new ModelAndView("ManageProject", projectDetails);
	}

	@RequestMapping(value = "/ClearTestExecutions", method = RequestMethod.GET)
	public ModelAndView clearExecutionsOfTest(@RequestParam("methodId") long id) {
		TestInfo testInfo = testInfoService.load(id);
		for (ExecInfo execInfo : execInfoService.listBy(testInfo)) {
			execInfoService.delete(execInfo);
		}
		long projectId = testInfo.getClassInfo().getProject().getId();

		return new ModelAndView("redirect:/ManageProject", "id", projectId);
	}

	@RequestMapping(value = "/ClearAllTestsExecutions", method = RequestMethod.GET)
	public ModelAndView clearAllTestsExecutions(@RequestParam("classId") long id) {
		ClassInfo classInfo = classInfoService.load(id);
		for (TestInfo testInfo : classInfo.getTestInfo()) {
			for (ExecInfo execInfo : execInfoService.listBy(testInfo)) {
				execInfoService.delete(execInfo);
			}
		}
		long projectId = classInfo.getProject().getId();

		return new ModelAndView("redirect:/ManageProject", "id", projectId);
	}

	@RequestMapping(value = "/DeleteProject", method = RequestMethod.GET)
	public ModelAndView deleteProject(@RequestParam("projectId") long id) {
		Project project = projectService.load(id);
		projectService.delete(project);
		return new ModelAndView("redirect:/ShowProjects");
	}

	private String constructSaveLocation(ProjectForm projectForm, MultipartFile file) {
		String rootDir = "C:\\";
		StringBuilder path = new StringBuilder();

		path.append(rootDir).append(JAR_SAVE_LOCATION);
		path.append(projectForm.getName()).append("\\").append(file.getOriginalFilename());
		path.append("-");
		path.append(RandomStringUtils.randomNumeric(4));
		path.append("\\").append(file.getOriginalFilename());
		return path.toString();
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadJar(@RequestParam("projectId") long projectId, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Project project = projectService.get(projectId);

		// ServletContext context = request.getServletContext();

		File downloadFile = new File(project.getJarPath());
		FileInputStream inputStream = new FileInputStream(downloadFile);

		String mimeType = project.getJarPath();

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "The test jar";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		ByteArrayInputStream bis = new ByteArrayInputStream(project.getTestJar());

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}

	private void generateClassStructure(List<CtClass> classes, Project project) throws Exception {

		for (CtClass class1 : classes) {
			try {
				List<TestInfo> testInfos = new ArrayList<TestInfo>();
				CtMethod[] methods = class1.getDeclaredMethods();
				ClassInfo classInfo = new ClassInfo();

				classInfo.setName(class1.getSimpleName());
				classInfo.setQualifiedName(class1.getName());
				classInfo.setProject(project);
				classInfoService.save(classInfo);
				if (classInfo.getTestInfo() == null) {
					classInfo.setTestInfo(new HashSet<TestInfo>());
				}
				for (CtMethod method1 : methods) {
					TestInfo testInfo = new TestInfo();
					for (Object method : method1.getAnnotations()) {
						if (method.toString().equals("@org.junit.Test")) {
							testInfo.setName(method1.getName());
							testInfo.setClassInfo(classInfo);
							testInfos.add(testInfo);
							classInfo.getTestInfo().add(testInfo);
						}
					}
				}
				testInfoService.saveAll(testInfos);
				classInfo.setNumberOfTests(testInfos.size());
				classInfoService.update(classInfo);
			} finally {
				class1.detach();
			}
		}
	}

	private void clearOldData(Project project) {
		List<ClassInfo> classSet = classInfoService.listBy(project);
		try {
			for (ClassInfo classInfo : classSet) {
				// classInfo = (ClassInfo) classIterator.next();
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
		for (ClassInfo classInfo : classes) {
			methods.addAll(testInfoService.listBy(classInfo));
		}
		projectDetails.addAttribute("testInfos", methods);
		projectDetails.addAttribute("projectsList", projectService.list());
		return projectDetails;
	}
}
