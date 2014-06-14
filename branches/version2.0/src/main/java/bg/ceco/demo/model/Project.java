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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {

	@Id
	@Column(name = "PPROJECT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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
	private byte[] testJar;

	@Column(name = "DEPENDENCY_JAR")
	@Lob
	private byte[] dependencyJar;

	@Column(name = "DATE_CREATION")
	private Date dateCreation;

	@Column(name = "DATE_MODIFICATION")
	private Date dateModification;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<ClassInfo> classInfos;

	// @Column(name = "TEST_COUNT")
	// @NotNull
	// private int testCount;

	// @Column(name = "CLASS_COUUN")
	// @NotNull
	// private int classCount;

	public Project() {
	}

	public Project(Long id, String projectName, String jarName, String dependencyJarName, String jarPath, String dependencyJarPath,
			String description, byte[] testJar, byte[] dependencyJar, Date dateCreation, Date dateModification, Set<ClassInfo> classInfos) {
		this.id = id;
		this.projectName = projectName;
		this.jarName = jarName;
		this.dependencyJarName = dependencyJarName;
		this.jarPath = jarPath;
		this.dependencyJarPath = dependencyJarPath;
		this.description = description;
		this.testJar = testJar;
		this.dependencyJar = dependencyJar;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.classInfos = classInfos;
	}

	public Set<ClassInfo> getClassInfos() {
		return classInfos;
	}

	public void setClassInfos(Set<ClassInfo> classInfos) {
		this.classInfos = classInfos;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	// public int getTestCount() {
	// return testCount;
	// }
	//
	// public void setTestCount(int testCount) {
	// this.testCount = testCount;
	// }

	// public int getClassCount() {
	// return classCount;
	// }
	//
	// public void setClassCount(int classCount) {
	// this.classCount = classCount;
	// }
}
