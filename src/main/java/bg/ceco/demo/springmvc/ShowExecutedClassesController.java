package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ShowExecutedClassesController {

	private static final String SCREENS_LOCATION = "\\src\\main\\webapp\\screenshots";
	
	@RequestMapping(value = "/Index", method = RequestMethod.GET)
	public ModelAndView displayTestClasses (@ModelAttribute("dirInfo") DirInfo dirInfo) throws Exception {
		return new ModelAndView("Index", "dirInfo", getTestClasses());
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
//						testInfo.setPath(test.getCanonicalPath());									
//						Date dateExecuted = DateUtils.parseDate(getTestExecutions(test.getCanonicalPath()),
//								new String[] { "dd.MM.yyyy HH-mm-ss" });
//						testInfo.setExecutionDate(dateExecuted);
						testInfos.add(testInfo);
						
					}
				bean.setTestInfo(testInfos);
				dirInfos.add(bean);
			}			
			return dirInfos;
		} finally {
		}
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
}
