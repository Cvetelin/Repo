package bg.ceco.demo.springmvc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bg.ceco.demo.logic.ProjectService;
import bg.ceco.demo.model.Project;
@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/AddProject", method = RequestMethod.GET)
	public String showAdd (@ModelAttribute ProjectForm projectForm, BindingResult result) {
		return "AddProject";
	}
	
	@RequestMapping(value="/CreateProject", method = RequestMethod.POST)
	public @ResponseBody String add(@ModelAttribute("projectForm")  ProjectForm projectForm, BindingResult result,
			@RequestParam("testJar") MultipartFile testJar, @RequestParam("depJar") MultipartFile depJar) {
		FileValidator fileValidator = new FileValidator();
		fileValidator.validate(testJar, result);
		
		Project project = new Project();
		if(depJar != null) {
			fileValidator.validate(depJar, result);			
		}
		
		String name = testJar.getOriginalFilename();
			 try {						 	
				 project.setDateCreation(new Date());
				 project.setDependencyJar(depJar.getBytes());
				 project.setDependencyJarName(depJar.getName());
				 project.setDependencyJarPath(project.getDependencyJarPath());
				 project.setDescription(project.getDescription());
				 project.setJarName(testJar.getName());
				 project.setJarPath(project.getJarPath());
				 project.setProjectName(project.getProjectName());
				 project.setTestJar(testJar.getBytes());
				 projectService.save(project);
//			        Blob b = lh.createBlob(file.getInputStream(), file.);
//	                byte[] bytes = testJar.getBytes();
//	                BufferedOutputStream stream =
//	                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
//	                stream.write(bytes);
//	                stream.close();
	                return "Load file " + name + " into " + name + "-uploaded !";
	            } catch (Exception e) {
	                return "File upload faild! File name: " + name + " => " + e.getMessage();
	            }
	}
}
