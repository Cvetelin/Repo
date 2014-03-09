package bg.ceco.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 * 
 */
@Entity
public class ClassInfo {
	
	@Id
	@Column(name = "CLASS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String path;
	private Date executionDate;
	private List<TestDirInfo> testInfo;
	private long testId;
	private boolean success;
		
	public long getTestId() {
		return testId;
	}
	public void setTestId(long testId) {
		this.testId = testId;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public List<TestDirInfo> getTestInfo() {
		return testInfo;
	}
	public void setTestInfo(List<TestDirInfo> testInfo) {
		this.testInfo = testInfo;
	}
	
	
 
}
