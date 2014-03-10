package bg.ceco.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ExecInfo {
	@Id
	@Column(name = "EXECUTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String path;
	private Date executionDate;
//	private String pathToParentDir;
//	private String parentName;
	private long testId;
	
	
	public ExecInfo() {
	
	}

	public ExecInfo(long id, String name, String path, Date executionDate,
		long testId) {
	this.id = id;
	this.name = name;
	this.path = path;
	this.executionDate = executionDate;
	this.testId = testId;
}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

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
	
	
//	public String getPathToParentDir() {
//		return pathToParentDir;
//	}
//	
//	public void setPathToParentDir(String pathToParentDir) {
//		this.pathToParentDir = pathToParentDir;
//	}
//
//	public String getParentName() {
//		return parentName;
//	}
//
//	public void setParentName(String parentName) {
//		this.parentName = parentName;
//	}
}
