package bg.ceco.demo.springmvc;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * 
 */
public class TestClassDirInfo {

	private String name;
	private String testClassName;
	private String path;
	private String classPath;
	private Date executionDate;
	private List<TestInfo> testInfo;
	
	
 	public List<TestInfo> getTestInfo() {
		return testInfo;
	}
	public void setTestInfo(List<TestInfo> testInfo) {
		this.testInfo = testInfo;
	}
	
	/**
	 * 
	 * @return the name of the executed the class
	 */
	public String getTestClassName() {
		return testClassName;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param testClass
	 */
	public void setTestClassName(String testClassName) {
		this.testClassName = testClassName;
	}
	/**
	 * 
	 * @return path to the directory where the test is 
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * 
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * 
	 * @return the exact time of time execution
	 */
	public Date getExecutionDate() {
		return executionDate;
	}
	
	/**
	 * 
	 * @param executionDate
	 */
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	
	/**
	 * 
	 * @return path to the directory where the test class is
	 */
	public String getClassPath() {
		return classPath;
	}
	
	/**
	 * 
	 * @param classPath
	 */
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	
}
