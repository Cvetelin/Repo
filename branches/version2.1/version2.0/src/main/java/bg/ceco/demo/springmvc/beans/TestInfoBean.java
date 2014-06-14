package bg.ceco.demo.springmvc.beans;

import java.util.Date;

import bg.ceco.demo.model.TestInfo;

public class TestInfoBean {
	
	private String name;
	
	private long id;
	
	private Date executionDate;
	
	private int numberOfExections;
	
	private boolean lastRunStatus;


	public int getNumberOfExections() {
		return numberOfExections;
	}

	public void setNumberOfExections(int numberOfExections) {
		this.numberOfExections = numberOfExections;
	}

	public boolean isLastRunStatus() {
		return lastRunStatus;
	}

	public void setLastRunStatus(boolean lastRunStatus) {
		this.lastRunStatus = lastRunStatus;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	
	
}
