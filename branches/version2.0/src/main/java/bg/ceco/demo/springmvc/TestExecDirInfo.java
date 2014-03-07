package bg.ceco.demo.springmvc;

import java.util.Date;

public class TestExecDirInfo {
	
	private String name;
	private String path;
	private Date executionDate;
	private String pathToParentDir;
	private String parentName;
	
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
	
	public String getPathToParentDir() {
		return pathToParentDir;
	}
	
	public void setPathToParentDir(String pathToParentDir) {
		this.pathToParentDir = pathToParentDir;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
