package bg.ceco.demo.struts;

import java.util.Date;

/**
 * @author Administrator
 * 
 */
public class DirInfo {

	private String name;
	private String path;
	private Date executionDate;

	public Date getexecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
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

}
