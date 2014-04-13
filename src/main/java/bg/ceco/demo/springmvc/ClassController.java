package bg.ceco.demo.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bg.ceco.demo.logic.ClassInfoService;
import bg.ceco.demo.logic.ExecInfoService;
import bg.ceco.demo.logic.ProjectService;
import bg.ceco.demo.logic.TestInfoService;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.TestInfo;

@Controller
public class ClassController {
	@Autowired
	private ProjectService projectService;

	@Autowired
	private ClassInfoService classInfoService;

	@Autowired
	private TestInfoService testInfoService;

	@Autowired
	public ExecInfoService execInfoService;

	@RequestMapping(value = "/ShowClassDetails", method = RequestMethod.GET)
	public ModelAndView showMethodsOfClass(@RequestParam("classId") long classId) {
		ClassInfo classInfo = classInfoService.load(classId);
		List<TestInfo> testInfos = testInfoService.listBy(classInfo);
		Project project = projectService.load(classInfo.getProject().getId());
		ModelMap classDetails = new ModelMap();
		classDetails.addAttribute("project", project);
		classDetails.addAttribute("classInfos", classInfo);
		classDetails.addAttribute("testInfos", testInfos);
		return new ModelAndView("ShowClassDetails", classDetails);
	}
}
