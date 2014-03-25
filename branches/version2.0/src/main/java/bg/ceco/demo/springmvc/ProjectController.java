package bg.ceco.demo.springmvc;

import java.util.Date;

import org.hibernate.SessionFactory;
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

import bg.ceco.demo.logic.ProjectService;
import bg.ceco.demo.model.Project;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(value = "/ShowProjects", method = RequestMethod.GET)
	public ModelAndView showProjects() {
		ModelMap map = new ModelMap();
		map.addAttribute("projects", projectService.list());
		return new ModelAndView("ShowProjects", map);
	}
	
	@RequestMapping(value = "/EditProject", method = RequestMethod.GET)
	public ModelAndView editProject(@RequestParam("id") long id) {
		Project project = projectService.load(id);
		ProjectForm form = new ProjectForm();
		form.setName(project.getProjectName());
		form.setDescription(project.getDescription());		
		ModelMap map = new ModelMap();
		map.addAttribute("project", form);
		return new ModelAndView("redirect:/app/AddProject", map);
	}

	@RequestMapping(value = "/AddProject", method = RequestMethod.GET)
	public String showAdd(@ModelAttribute ProjectForm projectForm,
			BindingResult result) {
		return "AddProject";
	}

	@RequestMapping(value = "/CreateProject", method = RequestMethod.POST)
	public ModelAndView add(
			@ModelAttribute("projectForm") ProjectForm projectForm,
			BindingResult result,
			@RequestParam("testJar") MultipartFile testJar,
			@RequestParam("depJar") MultipartFile depJar) {
		FileValidator fileValidator = new FileValidator();
		fileValidator.validate(testJar, result);

		Project project = new Project();
		if (!(depJar.getSize() == 0)) {
			fileValidator.validate(depJar, result);
		}
		try {
			project.setDateCreation(new Date());
			project.setDependencyJar(depJar.getBytes());
			project.setDependencyJarName(depJar.getOriginalFilename());

			project.setDescription(projectForm.getDescription());
			project.setJarName(testJar.getOriginalFilename());

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
			return new ModelAndView("ShowProjects");
		}
	}
}
