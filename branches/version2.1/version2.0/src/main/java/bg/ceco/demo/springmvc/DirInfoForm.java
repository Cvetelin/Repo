package bg.ceco.demo.springmvc;

import java.util.List;

import bg.ceco.demo.model.ClassInfo;

public class DirInfoForm {

	private String[] delete;
	private List<ClassInfo> dirInfo;

	public String[] getDelete() {
		return delete;
	}

	public void setDelete(String[] delete) {
		this.delete = delete;
	}

	public List<ClassInfo> getDirInfo() {
		return dirInfo;
	}

	public void setDirInfo(List<ClassInfo> dirInfo) {
		this.dirInfo = dirInfo;
	}

}
