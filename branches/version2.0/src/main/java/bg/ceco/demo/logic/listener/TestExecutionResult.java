package bg.ceco.demo.logic.listener;

import org.junit.runner.Result;

public class TestExecutionResult {

	private String testName;
	private Result result;
	private String classQualifiedName;
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getClassQualifiedName() {
		return classQualifiedName;
	}
	public void setClassQualifiedName(String classQualifiedName) {
		this.classQualifiedName = classQualifiedName;
	}
	
	
}
