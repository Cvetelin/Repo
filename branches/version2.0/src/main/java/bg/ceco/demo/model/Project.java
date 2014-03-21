package bg.ceco.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {
	
	@Id
	@Column(name = "PPROJECT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "PROJECT_NAME")
	private String projectName;
	
	@Column(name = "JAR_NAME")
	private String jarName;
	
	@Column(name = "DEPENDENCY_JAR_NAME")
	private String dependencyJarName;
	
	@Column(name = "JAR_PATH")
	private String jarPath;
	
	@Column(name = "DEPENDENCY_JAR_PATH")
	private String dependencyJarPath;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "TEST_JAR")
	@Lob
	private byte[] testJar;
	
	@Column(name = "DEPENDENCY_JAR")
	@Lob
	private byte[] dependencyJar;
	
	@Column(name = "DATE_CREATION")
	private Date dateCreation;	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getJarName() {
		return jarName;
	}
	public void setJarName(String jarName) {
		this.jarName = jarName;
	}
	public String getDependencyJarName() {
		return dependencyJarName;
	}
	public void setDependencyJarName(String dependencyJarName) {
		this.dependencyJarName = dependencyJarName;
	}
	public String getJarPath() {
		return jarPath;
	}
	public void setJarPath(String jarPath) {
		this.jarPath = jarPath;
	}
	public String getDependencyJarPath() {
		return dependencyJarPath;
	}
	public void setDependencyJarPath(String dependencyJarPath) {
		this.dependencyJarPath = dependencyJarPath;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getTestJar() {
		return testJar;
	}
	public void setTestJar(byte[] testJar) {
		this.testJar = testJar;
	}
	public byte[] getDependencyJar() {
		return dependencyJar;
	}
	public void setDependencyJar(byte[] dependencyJar) {
		this.dependencyJar = dependencyJar;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	
}
