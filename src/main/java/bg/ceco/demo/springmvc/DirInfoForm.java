package bg.ceco.demo.springmvc;

import java.util.List;

public class DirInfoForm {

	private String[] delete;
	private List<TestClassDirInfo> dirInfo;

	public String[] getDelete() {
		return delete;
	}

	public void setDelete(String[] delete) {
		this.delete = delete;
	}

	public List<TestClassDirInfo> getDirInfo() {
		return dirInfo;
	}

	public void setDirInfo(List<TestClassDirInfo> dirInfo) {
		this.dirInfo = dirInfo;
	}

}
