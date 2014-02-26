package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Constants {
	private static final String SCREENS_LOCATION = "\\src\\main\\webapp\\screenshots";
	private static final String GALERY_INDEX_LOCATION = "\\src\\main\\webapp\\Galery.html";
	private static final String TAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t";
	private static final String URL = "http://localhost:8080/screenshots/";
	private static final String FORWARD_SUCCESS = "success";
	
	public static String sceensLocationPath() throws Exception {
		File rootDir = new File(".");
		String pathToFiles = rootDir.getCanonicalPath() + SCREENS_LOCATION;
		return pathToFiles;
	}
	
	
	@SuppressWarnings("unchecked")
	public static File[] dirListByAscendingDate(File folder) {
		if (!folder.isDirectory()) {
			return null;
		}
		File[] files = folder.listFiles();
		Arrays.sort(files, new Comparator() {
			public int compare(final Object o1, final Object o2) {
				return new Long(((File) o1).lastModified()).compareTo(new Long(((File) o2).lastModified()));
			}
		});
		return files;
	}
	
	@SuppressWarnings("unchecked")
	public static File[] dirListByDescendingDate(File folder) {
		if (!folder.isDirectory()) {
			return null;
		}
		File files[] = folder.listFiles();
		Arrays.sort(files, new Comparator() {
			public int compare(final Object o1, final Object o2) {
				return new Long(((File) o2).lastModified()).compareTo(new Long(((File) o1).lastModified()));
			}
		});
		return files;
	  } 
	
	public static String getLastTestExecution(String pathToDir) throws Exception {

			DirInfo bean = new DirInfo();
		File dir = new File(pathToDir);
		for (File child : Constants.dirListByAscendingDate(dir)) {

			if (".".equals(child.getName()) || "..".equals(child.getName())) {
				continue; // Ignore the self and parent aliases.\
			}
			bean.setTestName(child.getName());
			bean.setPath(child.getCanonicalPath());
			
		}
		return bean.getTestName();
	}
}
