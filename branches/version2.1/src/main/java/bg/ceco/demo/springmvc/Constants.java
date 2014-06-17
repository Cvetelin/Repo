package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.lang.time.DateUtils;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.TestInfo;


public class Constants {

	
	private static final String SCREENS_LOCATION = "\\src\\main\\webapp\\screenshots";
	private static final String GALERY_INDEX_LOCATION = "\\src\\main\\webapp\\Galery.html";
	public static final String TEST_LOCATION = "\\src\\test\\java";
	private static final String TAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t";
	private static final String URL = "http://localhost:8080/screenshots/";
	private static final String FORWARD_SUCCESS = "success";
	
	public static String sceensLocationPath() throws Exception {
		File rootDir = new File(".");
		String pathToFiles = rootDir.getCanonicalPath() + SCREENS_LOCATION;
		return pathToFiles;
	}
	
	public static String testLocationPath() throws Exception {
		File rootDir = new File(".");
		String pathToFiles = rootDir.getCanonicalPath() + TEST_LOCATION;
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
	
	public static Date getLastTestExecutionDate(String pathToDir) throws Exception {

		TestInfo bean = new TestInfo();
		File dir = new File(pathToDir);		
		bean.setExecutionDate(DateUtils.parseDate(dirListByDescendingDate(dir)[0].getName(), new String[] { "dd.MM.yyyy HH-mm-ss" }));
	
		return bean.getExecutionDate();
	}
}
