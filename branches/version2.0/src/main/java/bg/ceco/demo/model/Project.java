package bg.ceco.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;

@Entity
@Table(name = "PROJECT")
public class Project {
	
	@Id
	@Column(name = "PPROJECT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "TEST_JAR")
	@Lob
	private Blob testJar;
	
	@Column(name = "DEPENDENCY_JAR")
	@Lob
	private Blob dependencyJar;
	
	@Column(name = "DATE_CREATION")
	private Date dateCreation;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getTestJar() {
		return testJar;
	}
	public void setTestJar(Blob testJar) {
		this.testJar = testJar;
	}
	public Blob getDependencyJar() {
		return dependencyJar;
	}
	public void setDependencyJar(Blob dependencyJar) {
		this.dependencyJar = dependencyJar;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	
}
