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

import org.hibernate.annotations.ForeignKey;

/**
 * @author Administrator
 * 
 */
@Entity
@Table(name="CLASS")
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
	private Date executionDate;
//	private List<TestDirInfo> testInfo;
		
	@Column(name = "SUCCESS")
	private boolean success;	
	
	@ManyToOne(targetEntity = Project.class)
	@JoinColumn(name = "PPROJECT_ID", nullable = false)
	private long projectId;
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public ClassInfo() {
	}	
	
	public ClassInfo(long id, String name, String qualifiedName, String path,
			Date executionDate, boolean success, long projectId) {
		this.id = id;
		this.name = name;
		this.qualifiedName = qualifiedName;
		this.path = path;
		this.executionDate = executionDate;
		this.success = success;
		this.projectId = projectId;
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
