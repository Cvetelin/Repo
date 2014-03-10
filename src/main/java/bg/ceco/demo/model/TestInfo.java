package bg.ceco.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TestInfo {
	@Id
	@Column(name = "TEST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String path;
	private Date executionDate;
//	private List<TestExecDirInfo> testExecDirInfos;
	private long classId;
	
	
	
	public TestInfo() {
	
	}

	public TestInfo(long id, String name, String path, Date executionDate,
			List<ExecInfo> testExecDirInfos, long classId, long execId) {
		this.id = id;
		this.name = name;
		this.path = path;
		this.executionDate = executionDate;
//		this.testExecDirInfos = testExecDirInfos;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
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

//	public List<TestExecDirInfo> getTestExecDirInfos() {
//		return testExecDirInfos;
//	}
//
//	public void setTestExecDirInfos(List<TestExecDirInfo> testExecDirInfos) {
//		this.testExecDirInfos = testExecDirInfos;
//	}
	
	
}
