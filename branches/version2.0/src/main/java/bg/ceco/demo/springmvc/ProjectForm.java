package bg.ceco.demo.springmvc;


public class ProjectForm {
	private String name;
	private String description;
	private String pathToTestJar;
	private String pathToDependencyJar;
	
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
	public String getPathToTestJar() {
		return pathToTestJar;
	}
	public void setPathToTestJar(String pathToTestJar) {
		this.pathToTestJar = pathToTestJar;
	}
	public String getPathToDependencyJar() {
		return pathToDependencyJar;
	}
	public void setPathToDependencyJar(String pathToDependencyJar) {
		this.pathToDependencyJar = pathToDependencyJar;
	}
	
}
