package bg.ceco.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEST")
public class TestInfo {
	@Id
	@Column(name = "TEST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PATH")
	private String path;

	@Column(name = "EXECUTION_DATE")
	private Date executionDate;

	@ManyToOne(targetEntity = ClassInfo.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLASS_ID", nullable = false)
	private ClassInfo classInfo;

	@OneToMany(mappedBy = "testInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<ExecInfo> execInfo;
	
	public TestInfo() {
	}

	public TestInfo(long id, String name, String path, Date executionDate, ClassInfo classInfo) {
		this.id = id;
		this.name = name;
		this.path = path;
		this.executionDate = executionDate;
		this.classInfo = classInfo;
	}
	
	public Set<ExecInfo> getExecInfo() {
		return execInfo;
	}

	public void setExecInfo(Set<ExecInfo> execInfo) {
		this.execInfo = execInfo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
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

	// public List<TestExecDirInfo> getTestExecDirInfos() {
	// return testExecDirInfos;
	// }
	//
	// public void setTestExecDirInfos(List<TestExecDirInfo> testExecDirInfos) {
	// this.testExecDirInfos = testExecDirInfos;
	// }

}
