package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.naming.spi.DirectoryManager;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowExecutedTestsController {

	private static final String SCREENS_LOCATION = "\\src\\main\\webapp\\screenshots";
	private static final String GALERY_INDEX_LOCATION = "\\src\\main\\webapp\\Galery.html";
	private static final String TAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t";
	private static final String URL = "http://localhost:8080/screenshots/";
	private static final String FORWARD_SUCCESS = "success";

	private static Logger log = Logger.getLogger(ShowExecutedTestsController.class.getName());

	@RequestMapping(value = "/ShowExecutedTests", method = RequestMethod.GET)
	public ModelAndView diplayTests(@ModelAttribute("dirInfo") DirInfo dirInfo) throws Exception {
		List<DirInfo> info = getTestClasses();
		List<TestInfo> allTestInfo = new ArrayList<TestInfo>();		
		for (int i = 0; i < info.size(); i++) {
			Collection<TestInfo> t = info.get(i).getTestInfo();
			allTestInfo.addAll(t);
		}
		return new ModelAndView("ShowExecutedTests", "testInfo", allTestInfo);

	}
	
	@RequestMapping(value = "/ShowExecutedClassTests", method = RequestMethod.GET)
	public ModelAndView diplaySlectedClassTests(@RequestParam("path") String classPath) throws Exception {		
		return new ModelAndView("ShowExecutedTests", "dirInfo", getTestClasses(classPath));

	}

	public List<DirInfo> getTestClasses(String selectedClassPath) throws Exception {
		List<DirInfo> dirInfos = new ArrayList<DirInfo>();
		try {
			File classDir = new File(sceensLocationPath());
			for (File testclass : dirListByAscendingDate(classDir)) {
				File testDir = new File(testclass.getCanonicalPath());
				DirInfo bean = new DirInfo();
				bean.setTestClassName(testclass.getName());
				bean.setClassPath(testclass.getCanonicalPath());
				if(StringUtils.equals(testclass.getCanonicalPath(), selectedClassPath)) {
					for (File test : dirListByAscendingDate(testDir)) {
						bean.setTestName(test.getName());
						bean.setPath(test.getCanonicalPath());
						Date dateExecuted = DateUtils.parseDate(getTestExecutions(test.getCanonicalPath()),
								new String[] { "dd.MM.yyyy HH-mm-ss" });
						bean.setExecutionDate(dateExecuted);
						dirInfos.add(bean);
					}
				}
				dirInfos.add(bean);
			}
			return dirInfos;
		} finally {
		}
	}
	
	public List<DirInfo> getTestClasses() throws Exception {
		List<DirInfo> dirInfos = new ArrayList<DirInfo>();
		try {
			File classDir = new File(sceensLocationPath());
			for (File testclass : dirListByAscendingDate(classDir)) {
				File testDir = new File(testclass.getCanonicalPath());
				DirInfo bean = new DirInfo();
				bean.setTestClassName(testclass.getName());
				bean.setClassPath(testclass.getCanonicalPath());
				List<TestInfo> testInfos = new ArrayList<TestInfo>();
					for (File test : dirListByAscendingDate(testDir)) {						
						TestInfo  testInfo = new TestInfo();
						testInfo.setName(test.getName());
						testInfo.setPath(test.getCanonicalPath());									
						Date dateExecuted = DateUtils.parseDate(getTestExecutions(test.getCanonicalPath()),
								new String[] { "dd.MM.yyyy HH-mm-ss" });
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

	public List<DirInfo> getTestsNames(String classPath) throws Exception {
		
		try {
			List<DirInfo> dirInfos = new ArrayList<DirInfo>();
			File dir = new File(classPath);
			for (File child : dirListByAscendingDate(dir)) {

				if (".".equals(child.getName()) || "..".equals(child.getName())) {
					continue; // Ignore the self and parent aliases.\
				}
				DirInfo bean = new DirInfo();
				bean.setTestName(child.getName());
				bean.setPath(child.getCanonicalPath());
				Date dateExecuted = DateUtils.parseDate(getTestExecutions(child.getCanonicalPath()),
						new String[] { "dd.MM.yyyy HH-mm-ss" });
				bean.setExecutionDate(dateExecuted);
				dirInfos.add(bean);

			}
			return dirInfos;

		} finally {
		}
	}
	
	public List<DirInfo> getTestsNames() throws Exception {

		try {
			List<DirInfo> dirInfos = new ArrayList<DirInfo>();
			File dir = new File(sceensLocationPath());
			for (File child : dirListByAscendingDate(dir)) {

				if (".".equals(child.getName()) || "..".equals(child.getName())) {
					continue; // Ignore the self and parent aliases.\
				}
				DirInfo bean = new DirInfo();
				bean.setTestName(child.getName());
				bean.setPath(child.getCanonicalPath());
				Date dateExecuted = DateUtils.parseDate(getTestExecutions(child.getCanonicalPath()),
						new String[] { "dd.MM.yyyy HH-mm-ss" });
				bean.setExecutionDate(dateExecuted);
				dirInfos.add(bean);

			}
			return dirInfos;

		} finally {
		}
	}

	protected String getTestExecutions(String pathToDir) throws Exception {

		// List<DirInfo> dirInfos = new ArrayList<DirInfo>();
		DirInfo bean = new DirInfo();
		File dir = new File(pathToDir);
		for (File child : dirListByAscendingDate(dir)) {

			if (".".equals(child.getName()) || "..".equals(child.getName())) {
				continue; // Ignore the self and parent aliases.\
			}
			bean.setTestName(child.getName());
			bean.setPath(child.getCanonicalPath());
			// dirInfos.add(bean);
		}
		return bean.getTestName();
	}

	private static String sceensLocationPath() throws Exception {
		File rootDir = new File(".");
		String pathToFiles = rootDir.getCanonicalPath() + SCREENS_LOCATION;
		return pathToFiles;
	}

	@SuppressWarnings("unchecked")
	private static File[] dirListByAscendingDate(File folder) {
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
}
