package bg.ceco.demo.springmvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
import bg.ceco.demo.logic.TestInfoBean;
import bg.ceco.demo.logic.TestInfoService;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.ExecInfo;
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
		List<ExecInfo> execInfos = new ArrayList<ExecInfo>();

		Project project = projectService.load(classInfo.getProject().getId());
		ModelMap details = new ModelMap();
		details.addAttribute("projectsList", projectService.list());
		details.addAttribute("project", project);
		details.addAttribute("classInfo", classInfo);
		details.addAttribute("testInfos", populateTestInofbean(testInfos));

		execInfos = getLastExecutionOfTest(testInfos);
		details.addAttribute("execInfos", execInfos);
		return new ModelAndView("ShowClassDetails", details);
	}

	@RequestMapping(value = "/{id}/ShowClassDetails", method = RequestMethod.GET)
	public ModelAndView showRunsOfTest(@RequestParam("methodId") long methodId) {
		TestInfo testInfo = testInfoService.load(methodId);
		List<TestInfo> testInfos = testInfoService.listBy(testInfo.getClassInfo());
		ModelMap details = new ModelMap();
		details.addAttribute("projectsList", projectService.list());
		details.addAttribute("project", testInfo.getClassInfo().getProject());
		details.addAttribute("classInfo", testInfo.getClassInfo());
		details.addAttribute("testInfos", populateTestInofbean(testInfos));
		details.addAttribute("execInfos", testInfo.getExecInfo());

		return new ModelAndView("ShowClassDetails", details);

	}

	private List<ExecInfo> getLastExecutionOfTest(List<TestInfo> testInfos) {
		List<ExecInfo> execInfos = new ArrayList<ExecInfo>();
		for (Iterator<TestInfo> iterator = testInfos.iterator(); iterator.hasNext();) {
			TestInfo tInfo = (TestInfo) iterator.next();
			List<ExecInfo> eInfos = execInfoService.listBy(tInfo);
			execInfos.addAll(eInfos);
		}
		return execInfos;
	}

	@SuppressWarnings("unchecked")
	private List<ExecInfo> sortByDate(List<ExecInfo> eInfos) {

		// File files[] = folder.listFiles();
		Collections.sort(eInfos, new Comparator<ExecInfo>() {
			public int compare(ExecInfo ei1, ExecInfo ei2) {
				return ei1.getExecutionDate().compareTo(ei2.getExecutionDate());
			}

			// public int compare(final Object o1, final Object o2) {
			// return new Long(((File) o2).lastModified()).compareTo(new
			// Long(((File) o1).lastModified()));
			// }
		});
		return eInfos;
	}

	private List<TestInfoBean> populateTestInofbean(List<TestInfo> testInfos) {
		List<TestInfoBean> tBeans = new ArrayList<TestInfoBean>();
		for (TestInfo testInfo : testInfos) {
			TestInfoBean tbean = new TestInfoBean();
			List<ExecInfo> execI = execInfoService.listByExecDatedesc(testInfo);
			if (!execI.isEmpty()) {
				tbean.setLastRunStatus(execI.get(0).isStatus());
				tbean.setNumberOfExections(execI.size());
			}
			tbean.setName(testInfo.getName());
			tbean.setId(testInfo.getId());
			tbean.setExecutionDate(testInfo.getExecutionDate());
			tBeans.add(tbean);
		}

		return tBeans;
	}
}
