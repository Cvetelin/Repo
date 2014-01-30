package bg.ceco.demo.struts;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * 
 */
public class DirInfo {

	private String name;
	private String path;
	private Date executionDate;
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

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
