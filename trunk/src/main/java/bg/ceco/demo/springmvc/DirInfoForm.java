package bg.ceco.demo.springmvc;

import java.util.List;

public class DirInfoForm {
	
	private String []  delete;
	private List<DirInfo> dirInfo;
	public String[] getDelete() {
		return delete;
	}
	public void setDelete(String[] delete) {
		this.delete = delete;
	}
	public List<DirInfo> getDirInfo() {
		return dirInfo;
	}
	public void setDirInfo(List<DirInfo> dirInfo) {
		this.dirInfo = dirInfo;
	}

	

}

