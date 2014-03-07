package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

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
	
	public static Date getLastTestExecutionDate(String pathToDir) throws Exception {

		TestInfo bean = new TestInfo();
		File dir = new File(pathToDir);		
		bean.setExecutionDate(DateUtils.parseDate(dirListByDescendingDate(dir)[0].getName(), new String[] { "dd.MM.yyyy HH-mm-ss" }));
	
		return bean.getExecutionDate();
	}
	
	public static TestClassDirInfo getTestClassDirInfo(String selectedClassPath) throws Exception {
//		List<DirInfo> dirInfos = new ArrayList<DirInfo>();
		TestClassDirInfo testClassDirInfo = new TestClassDirInfo();
		try {
			File testClassDir = new File(selectedClassPath);
			testClassDirInfo.setName(testClassDir.getName());
			testClassDirInfo.setPath(testClassDir.getCanonicalPath());
			File classDir = new File(Constants.sceensLocationPath());
//			for (File testclass : Constants.dirListByAscendingDate(classDir)) {
//				File testDir = new File(testclass.getCanonicalPath());
//				DirInfo bean = new DirInfo();
//				bean.setTestClassName(testclass.getName());
//				bean.setClassPath(testclass.getCanonicalPath());
				List<TestInfo> testInfos = new ArrayList<TestInfo>();
//				if(StringUtils.equals(testclass.getCanonicalPath(), selectedClassPath)) {
					for (File test : Constants.dirListByAscendingDate(new File(selectedClassPath))) {
						TestInfo  testInfo = new TestInfo();
						testInfo.setName(test.getName());
						testInfo.setPath(test.getCanonicalPath());						
						Date dateExecuted = getLastTestExecutionDate(test.getCanonicalPath());
						testInfo.setExecutionDate(dateExecuted);
						testInfos.add(testInfo);
					}
//				}
//				bean.setTestInfo(testInfos);
				testClassDirInfo.setTestInfo(testInfos);
//			}
			return testClassDirInfo;
		} finally {
		}
	}
	
	public static List<TestClassDirInfo> getTestClassesDirInfo() throws Exception {
		List<TestClassDirInfo> dirInfos = new ArrayList<TestClassDirInfo>();
		try {
			File classDir = new File(Constants.sceensLocationPath());
			for (File testclass : Constants.dirListByAscendingDate(classDir)) {
				File testDir = new File(testclass.getCanonicalPath());
				TestClassDirInfo bean = new TestClassDirInfo();
				bean.setTestClassName(testclass.getName());
				bean.setClassPath(testclass.getCanonicalPath());
				List<TestInfo> testInfos = new ArrayList<TestInfo>();
					for (File test : Constants.dirListByAscendingDate(testDir)) {						
						TestInfo  testInfo = new TestInfo();
						testInfo.setName(test.getName());
						testInfo.setPath(test.getCanonicalPath());									
						Date dateExecuted = Constants.getLastTestExecutionDate(test.getCanonicalPath());
						testInfo.setExecutionDate(dateExecuted);
						testInfos.add(testInfo);
						
					}
				bean.setTestInfo(testInfos);
				dirInfos.add(bean);
			}			
			return dirInfos;
		} finally {
		}
	}
}
