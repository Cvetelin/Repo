package bg.ceco.demo.model;

import java.util.Date;
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

/**
 * @author Administrator
 * 
 */
@Entity
@Table(name = "CLASS")
public class ClassInfo {

	@Id
	@Column(name = "CLASS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "QUALIFIED_NAME")
	private String qualifiedName;

	@Column(name = "PATH")
	private String path;

	@Column(name = "EXCUTION_DATE")
	private Date executionDate;
	// private List<TestDirInfo> testInfo;

	@Column(name = "SUCCESS")
	private boolean success;

	@ManyToOne(targetEntity = Project.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "PPROJECT_ID", nullable = false)
	private Project project;

	public Project getProject() {
		return project;
	}

	@OneToMany(mappedBy = "classInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<TestInfo> testInfo;

	public void setProject(Project project) {
		this.project = project;
	}

	public ClassInfo() {
	}

	public ClassInfo(long id, String name, String qualifiedName, String path, Date executionDate, boolean success, Project project) {
		this.id = id;
		this.name = name;
		this.qualifiedName = qualifiedName;
		this.path = path;
		this.executionDate = executionDate;
		this.success = success;
		this.project = project;
	}

	public Set<TestInfo> getTestInfo() {
		return testInfo;
	}

	public void setTestInfo(Set<TestInfo> testInfo) {
		this.testInfo = testInfo;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
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
}
