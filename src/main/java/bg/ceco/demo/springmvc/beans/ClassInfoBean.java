package bg.ceco.demo.springmvc.beans;

import java.util.Collection;

import bg.ceco.demo.model.ClassInfo;

public class ClassInfoBean {

	private ClassInfo classInfo;
	private int numberOfTests;
	private int numberOfAllExecutions;
	private Collection<TestInfoBean> testInfoBeans;

	public int getNumberOfTests() {
		return numberOfTests;
	}

	public void setNumberOfTests(int numberOfTests) {
		this.numberOfTests = numberOfTests;
	}

	public ClassInfo getClasInfo() {
		return classInfo;
	}

	public void setClasInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public Collection<TestInfoBean> getTestInfoBeans() {
		return testInfoBeans;
	}

	public void setTestInfoBeans(Collection<TestInfoBean> testInfoBeans) {
		this.testInfoBeans = testInfoBeans;
	}

	public int getNumberOfAllExecutions() {
		return numberOfAllExecutions;
	}

	public void setNumberOfAllExecutions(int numberOfAllExecutions) {
		this.numberOfAllExecutions = numberOfAllExecutions;
	}

}
