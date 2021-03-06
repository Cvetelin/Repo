package bg.ceco.demo.logic.listener;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.springframework.stereotype.Component;


@Component
public class TestListenerImpl extends RunListener {

	/**
	 * Called before any tests have been run.
	 * */
	public void testRunStarted(Description description) throws java.lang.Exception {
		System.out.println("Number of testcases to execute : " + description.testCount());
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
}
