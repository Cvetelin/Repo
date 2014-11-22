package bg.ceco.demo.springmvc.beans;

import java.util.Collection;

public class ManageProjectBean {

	private Collection<TestInfoBean> testBeans;
	
	public Collection<TestInfoBean> getTestBeans() {
		return testBeans;
	}

	public void setTestBeans(Collection<TestInfoBean> testBeans) {
		this.testBeans = testBeans;
	}

	private String className;

	private long classId;


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}
}
