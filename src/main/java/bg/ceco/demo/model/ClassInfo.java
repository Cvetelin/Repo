package bg.ceco.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.velocity.tools.config.DefaultKey;

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
	
	public ClassInfo() {
	}
	
	public ClassInfo(long id, String name, String path, Date executionDate,
			long testId, boolean success) {
		this.id = id;
		this.name = name;
		this.path = path;
		this.executionDate = executionDate;
		this.success = success;
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
//	public List<TestDirInfo> getTestInfo() {
//		return testInfo;
//	}
//	public void setTestInfo(List<TestDirInfo> testInfo) {
//		this.testInfo = testInfo;
//	}
	
	
 
}
