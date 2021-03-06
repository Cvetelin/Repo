package bg.ceco.demo.springmvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bg.ceco.demo.logic.ClassInfoService;
import bg.ceco.demo.logic.ExecInfoService;
import bg.ceco.demo.logic.ProjectService;
import bg.ceco.demo.logic.TestInfoService;
import bg.ceco.demo.logic.listener.TestExecutionResult;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.ExecInfo;
import bg.ceco.demo.model.TestInfo;

@Controller
public class RunTestsController {
	@Autowired
	private ClassInfoService classInfoService;

	@Autowired
	private TestInfoService testInfoService;

	@Autowired
	private ExecInfoService execInfoService;

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/runClass", method = RequestMethod.GET)
	public ModelAndView runClassWithJunit(@RequestParam("classId") long id) {
		ClassInfo classInfo = classInfoService.get(id);
		Result result = null;
		TestRunner runner = new TestRunner();
		TestInfo testInfo = new TestInfo();
		try {
			result = runner.runClass(classInfo);
			// if (result.getFailureCount() == 0) {
			// classInfo.setSuccess(true);
			// }
			classInfo.setSuccess(result.wasSuccessful());
			Date date = new Date();
			classInfo.setExecutionDate(date);
			classInfo.setNumberOfTests(result.getRunCount());
			classInfo.setRunTime(result.getRunTime());
			classInfo.setNumberOfFailedTests(result.getFailureCount());
			Set<TestInfo> failedTests = new HashSet<TestInfo>();
			List<Failure> failures = result.getFailures();
			if (isInitializationError(failures, classInfo, date)) {
				classInfoService.update(classInfo);
				return new ModelAndView("redirect:/ShowClassDetails", "classId", classInfo.getId());
			}

			if (!failures.isEmpty()) {
				for (Iterator<Failure> iterator = failures.iterator(); iterator.hasNext();) {
					Failure failure = (Failure) iterator.next();
					testInfo = matchMethods(classInfo, failure.getDescription().getMethodName());
					if (testInfo != null) {
						updateOnFailureClass(testInfo, date, failure);
						failedTests.add(testInfo);
					}
				}
			}

			TestInfo testInClass = null;
			for (TestInfo tInfo : classInfo.getTestInfo()) {
				if (!failedTests.contains(tInfo)) {
					testInClass = testInfoService.loadBy(classInfo, tInfo.getName());
					updateOnSuccessClass(testInClass, date);
				}
			}
			classInfoService.update(classInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/ShowClassDetails", "classId", classInfo.getId());
	}

	@RequestMapping(value = "/runTest", method = RequestMethod.GET)
	public ModelAndView runMethodWithJunit(@RequestParam("methodId") long methodId, HttpServletRequest request) {
		TestInfo testInfo = testInfoService.load(methodId);
		ClassInfo classInfo = classInfoService.load(testInfo.getClassInfo().getId());
		Result result = null;
		TestRunner runner = new TestRunner();
		try {
			Date date = new Date();
			result = runner.runMethod(classInfo, testInfo);
			List<Failure> failures = result.getFailures();
			if (isInitializationError(failures, classInfo, date)) {
				return new ModelAndView("redirect:/ShowClassDetails", "classId", classInfo.getId());
			}

			if (!failures.isEmpty()) {
				for (Iterator<Failure> iterator = failures.iterator(); iterator.hasNext();) {
					Failure failure = (Failure) iterator.next();
					testInfo = matchMethods(classInfo, failure.getDescription().getMethodName());
					updateOnFailure(testInfo, date, result);
				}
				return new ModelAndView("redirect:/ShowClassDetails", "classId", classInfo.getId());
			}
			updateOnSuccessMethod(testInfo, date, result);

			classInfo.setSuccess(isClassSuccesful(classInfo.getTestInfo()));
			classInfoService.update(classInfo);

		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
		}
		return new ModelAndView("redirect:/ShowClassDetails", "classId", classInfo.getId());
	}

	@RequestMapping(value = "/runMethods", method = RequestMethod.GET)
	public ModelAndView runMethodsWithJunit(@RequestParam("classId") long id, HttpServletRequest request) {
		ClassInfo classInfo = classInfoService.get(id);
		TestInfo testInfo = new TestInfo();
		int testFailureCount = 0;
		Long classRunTime = 0L;
		TestRunner runner = new TestRunner();
		try {
			Date executionDate = null;
			List<TestExecutionResult> testExecutionResult = runner.runMethods(classInfo);
			for (TestExecutionResult result : testExecutionResult) {
				List<Failure> failures = result.getResult().getFailures();
				testFailureCount += result.getResult().getFailureCount();
				classRunTime += result.getResult().getRunTime();
				executionDate = result.getExecutionDate();
				if (isInitializationError(failures, classInfo, result.getExecutionDate())) {

					return new ModelAndView("redirect:/ShowClassDetails", "classId", classInfo.getId());
				}

				if (!failures.isEmpty()) {
					for (Failure failure : failures) {
						// testInfo = testInfoService.loadBy(classInfo,
						// result.getTestName());
						testInfo = matchMethods(classInfo, failure.getDescription().getMethodName());
						if (testInfo != null) {
							updateOnFailure(testInfo, result.getExecutionDate(), result.getResult());
						}
					}
				} else {
					testInfo = testInfoService.loadBy(classInfo, result.getTestName());
					updateOnSuccessMethod(testInfo, result.getExecutionDate(), result.getResult());
				}
			}

			classInfo.setSuccess(isClassSuccesful(classInfo.getTestInfo()));
			classInfo.setNumberOfTests(testExecutionResult.size());
			classInfo.setNumberOfFailedTests(testFailureCount);
			classInfo.setRunTime(classRunTime);
			classInfo.setExecutionDate(executionDate);
			classInfoService.update(classInfo);
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/ShowClassDetails", "classId", classInfo.getId());
	}

	private TestInfo matchMethods(ClassInfo classInfo, String nameOfExecutedTest) {
		TestInfo testInClass = null;
		Set<TestInfo> testsInClass = classInfo.getTestInfo();
		for (TestInfo testInfo : testsInClass) {
			if (testInfo.getName().equals(nameOfExecutedTest)) {
				testInClass = testInfoService.loadBy(classInfo, testInfo.getName());
				return testInClass;
			}
		}
		return null;
	}

	private List<ExecInfo> getLastExecutionOfTest(Set<TestInfo> testInfos) {
		List<ExecInfo> execInfos = new ArrayList<ExecInfo>();
		for (TestInfo tInfo : testInfos) {
			List<ExecInfo> eInfos = execInfoService.listBy(tInfo);
			execInfos.addAll(eInfos);
		}
		return execInfos;
	}

	private boolean isClassSuccesful(Set<TestInfo> testInfos) {
		List<ExecInfo> execInfos = getLastExecutionOfTest(testInfos);
		for (ExecInfo execInfo : execInfos) {
			if (execInfo.getFailureReason() != null) {
				return false;
			}
		}
		return true;
	}

	private boolean isInitializationError(List<Failure> failures, ClassInfo classInfo, Date date) {
		ExecInfo execInfo = new ExecInfo();
		if (!failures.isEmpty() && failures.get(0).getDescription().getDisplayName().contains("initializationError")) {
			for (TestInfo tInfo : classInfo.getTestInfo()) {
				TestInfo tInClass = testInfoService.loadBy(classInfo, tInfo.getName());
				execInfo = new ExecInfo();
				execInfo.setExecutionDate(date);
				execInfo.setFailureReason(failures.get(0).getMessage());
				execInfo.setTestInfo(tInClass);
				execInfoService.save(execInfo);

				tInClass.setExecutionDate(date);
				testInfoService.update(tInClass);
			}
			return true;
		}
		return false;
	}

	private void updateOnSuccessClass(TestInfo testInfo, Date date) {
		ExecInfo execInfo = new ExecInfo();
		// TestInfo testInClass = testInfoService.loadBy(classInfo,
		// testInfo.getName());
		execInfo.setExecutionDate(date);
		execInfo.setStatus(true);
		execInfo.setTestInfo(testInfo);

		execInfoService.save(execInfo);

		testInfo.setExecutionDate(date);
		testInfoService.update(testInfo);
	}

	private void updateOnSuccessMethod(TestInfo testInfo, Date date, Result result) {
		ExecInfo execInfo = new ExecInfo();
		execInfo.setExecutionDate(date);
		execInfo.setStatus(true);
		execInfo.setTestInfo(testInfo);
		execInfo.setStatus(result.wasSuccessful());
		execInfo.setRunTime(result.getRunTime());
		execInfoService.save(execInfo);

		testInfo.setExecutionDate(date);
		testInfoService.update(testInfo);
	}

	private void updateOnFailure(TestInfo testInfo, Date date, Result result) {
		ExecInfo execInfo = new ExecInfo();
		execInfo.setExecutionDate(date);
		execInfo.setFailureReason(result.getFailures().get(0).getMessage() + "\n" + result.getFailures().get(0).getTrace());
		execInfo.setRunTime(result.getRunTime());
		execInfo.setStatus(result.wasSuccessful());
		execInfo.setTestInfo(testInfo);
		execInfoService.save(execInfo);

		testInfo.setExecutionDate(date);
		testInfoService.update(testInfo);
	}

	private void updateOnFailureClass(TestInfo testInfo, Date date, Failure failure) {
		ExecInfo execInfo = new ExecInfo();
		execInfo.setExecutionDate(date);
		execInfo.setFailureReason(failure.getMessage() + "\n" + failure.getTrace());
		execInfo.setTestInfo(testInfo);
		execInfoService.save(execInfo);

		testInfo.setExecutionDate(date);
		testInfoService.update(testInfo);
	}

	private String convertToTime(Long time) {
		Date date = new Date(time);
		SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SSS");
		String thetime = formatter.format(date);
		return thetime;
	}
}
