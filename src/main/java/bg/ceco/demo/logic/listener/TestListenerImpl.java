package bg.ceco.demo.logic.listener;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.ceco.demo.logic.ClassInfoService;
import bg.ceco.demo.logic.TestInfoService;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.TestInfo;

@Component
public class TestListenerImpl extends RunListener {

	private ClassInfo classInfo;

	private TestInfo testInfo;

	@Autowired
	ClassInfoService classInfoService;

	@Autowired
	TestInfoService testInfoService;

	public TestListenerImpl(ClassInfo cnfo) {
		this.classInfo = cnfo;
	}

	public TestListenerImpl(ClassInfo cnfo, TestInfo tInfo) {
		super();
		this.classInfo = cnfo;
		this.testInfo = tInfo;
	}

	public TestListenerImpl() {
	}

	/**
	 * Called before any tests have been run.
	 * */
	public void testRunStarted(Description description) throws java.lang.Exception {
		System.out.println("Number of testcases to execute : " + description.testCount());
		System.out.println("Method name : " + description.getMethodName());
	}

	/**
	 * Called when all tests have finished
	 * */
	public void testRunFinished(Result result) throws java.lang.Exception {
		System.out.println("Number of testcases executed : " + result.getRunCount());
		System.out.println("TEST RESULT : " + (result.getFailureCount() == 0 ? true : false));

	}

	/**
	 * Called when an atomic test is about to be started.
	 * */
	@Override
	public void testStarted(Description description) throws java.lang.Exception {
		matchMethods(classInfo, description.getMethodName());
		System.out.println("Starting execution of test case : " + description.getMethodName());

	}

	/**
	 * Called when an atomic test has finished, whether the test succeeds or
	 * fails.
	 * */
	public void testFinished(Description description) throws java.lang.Exception {
		System.out.println("Finished execution of test case : " + description.getMethodName());

	}

	/**
	 * Called when an atomic test fails.
	 * */
	public void testFailure(Failure failure) throws java.lang.Exception {
		System.out.println("Execution of test case failed : " + failure.getMessage());
		System.out.println("Execution of test case failed : " + failure.getException());
	}

	/**
	 * Called when a test will not be run, generally because a test method is
	 * annotated with Ignore.
	 * */
	public void testIgnored(Description description) throws java.lang.Exception {
		System.out.println("Execution of test case ignored : " + description.getMethodName());
	}

	private TestInfo matchMethods(ClassInfo classInfo, String nameOfExecutedTest) {
		try {
			TestInfo testInfo = testInfoService.loadBy(classInfo, nameOfExecutedTest);
			if (testInfo != null) {
				return testInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}