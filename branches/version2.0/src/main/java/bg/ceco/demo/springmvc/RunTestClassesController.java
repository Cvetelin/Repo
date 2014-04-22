package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang.StringUtils;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
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
import bg.ceco.demo.model.ExecInfo;
import bg.ceco.demo.model.TestInfo;
import bg.ceco.demo.selenium.TestRunner;

@Controller
public class RunTestClassesController {
	@Autowired
	private ClassInfoService classInfoService;

	@Autowired
	private TestInfoService testInfoService;

	@Autowired
	private ExecInfoService execInfoService;

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/RunClass", method = RequestMethod.GET)
	public ModelAndView runClassWithJunit(@RequestParam("id") long id) {
		ClassInfo classInfo = classInfoService.load(id);
		Result result = null;
		TestRunner runner = new TestRunner();
		try {
			result = runner.runClass(classInfo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result.getFailureCount() == 0) {
				classInfo.setSuccess(true);
			}
			Date date = new Date();
			classInfo.setExecutionDate(date);

			Set<TestInfo> testinfos = new HashSet<TestInfo>();
			List<Failure> failures = result.getFailures();
			TestInfo testInfo = new TestInfo();
			ExecInfo execInfo = new ExecInfo();

			for (Iterator iterator = failures.iterator(); iterator.hasNext();) {
				Failure failure = (Failure) iterator.next();
				testInfo = matchMethods(classInfo, failure.getDescription().getMethodName());
				if (testInfo != null) {
					failure.getException();
					execInfo.setExecutionDate(date);
					execInfo.setFailureReason(failure.getMessage() + "\n" + failure.getTrace());
					execInfo.setTestInfo(testInfo);

					testInfo.setExecutionDate(date);
					testInfo.setClassInfo(classInfo);

					execInfoService.save(execInfo);
					testInfoService.update(testInfo);
					classInfoService.update(classInfo);
				}
			}
		}
		return new ModelAndView("ShowTestClasses", "dirInfo", classInfoService.list());
	}

	@RequestMapping(value = "/GetTestClasses", method = RequestMethod.GET)
	public String getClasses() throws Exception {
		ModelMap map = new ModelMap();
		getAlltest();
		return "redirect:/app/ShowTestClasses";
	}

	private void getAlltest() throws Exception {
		FileUtils operate = new FileUtils();
		IOFileFilter fileFilter = FileFilterUtils.suffixFileFilter("java");
		Iterator<File> files = operate.iterateFiles(new File(Constants.testLocationPath()), fileFilter, TrueFileFilter.INSTANCE);
		while (files.hasNext()) {
			File file = (File) files.next();
			ClassInfo info = new ClassInfo();
			info.setName(file.getName());
			info.setPath(file.getCanonicalPath());
			info.setQualifiedName(constructQualifiedName(file.getCanonicalPath()));
			classInfoService.save(info);
		}
	}

	private String constructQualifiedName(String path) throws Exception {
		String qualifiedName = path.replace(Constants.testLocationPath() + "\\", StringUtils.EMPTY).replace("\\", ".")
				.replace(".java", StringUtils.EMPTY);
		// qualifiedName.replace("java", "class");
		return qualifiedName;
	}

	private TestInfo matchMethods(ClassInfo classInfo, String nameOfExecutedTest) {
		TestInfo testInClass = null;
		Set<TestInfo> testsInClass = classInfo.getTestInfo();
		for (Iterator iterator = testsInClass.iterator(); iterator.hasNext();) {
			TestInfo testInfo = (TestInfo) iterator.next();
			if (testInfo.getName().equals(nameOfExecutedTest)) {
				testInClass = testInfoService.loadBy(classInfo, testInfo.getName());
				return testInClass;
			}
		}
		return null;
	}
}
