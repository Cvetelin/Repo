package bg.ceco.demo.springmvc;

import java.util.Date;
import java.util.List;

public class TestInfo {

	private String name;
	private String path;
	private Date executionDate;
	private List<TestExecDirInfo> testExecDirInfos;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public List<TestExecDirInfo> getTestExecDirInfos() {
		return testExecDirInfos;
	}

	public void setTestExecDirInfos(List<TestExecDirInfo> testExecDirInfos) {
		this.testExecDirInfos = testExecDirInfos;
	}
	
	
}
