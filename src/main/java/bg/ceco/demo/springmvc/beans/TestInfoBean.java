package bg.ceco.demo.springmvc.beans;

import java.util.Collection;

import bg.ceco.demo.model.TestInfo;

public class TestInfoBean {
	private TestInfo testInfo;
	private int numebrOfRuns;
	private Collection<ExecInfoBean> execInfoBeans;

	public Collection<ExecInfoBean> getExecInfoBeans() {
		return execInfoBeans;
	}

	public void setExecInfoBeans(Collection<ExecInfoBean> execInfoBeans) {
		this.execInfoBeans = execInfoBeans;
	}

	public int getNumebrOfRuns() {
		return numebrOfRuns;
	}

	public void setNumebrOfRuns(int numebrOfRuns) {
		this.numebrOfRuns = numebrOfRuns;
	}

	public TestInfo getTestInfo() {
		return testInfo;
	}

	public void setTestInfo(TestInfo testInfo) {
		this.testInfo = testInfo;
	}

}
