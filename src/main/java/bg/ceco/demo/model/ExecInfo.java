package bg.ceco.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="EXECUTION")
public class ExecInfo {
	@Id
	@Column(name = "EXECUTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PATH")
	private String path;
	
	@Column(name = "EXECUTION_DATE")
	private Date executionDate;
	
	@Column(name = "FAILURE_REASON")
	private String failureReason;
	
	@ManyToOne(targetEntity = TestInfo.class)
	@JoinColumn(name = "TEST_ID", nullable = false)
	private TestInfo testInfo;
	
	public ExecInfo() {
	
	}

	public ExecInfo(long id, String name, String path, Date executionDate,
			TestInfo testInfo) {
	this.id = id;
	this.name = name;
	this.path = path;
	this.executionDate = executionDate;
	this.testInfo = testInfo;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TestInfo getTestInfo() {
		return testInfo;
	}

	public void setTestInfo(TestInfo testInfo) {
		this.testInfo = testInfo;
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
