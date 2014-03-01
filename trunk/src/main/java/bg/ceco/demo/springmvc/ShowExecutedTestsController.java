package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowExecutedTestsController {




	@RequestMapping(value = "/ShowExecutedTests", method = RequestMethod.GET)
	public ModelAndView diplayTests(@RequestParam("path") String classPath, ModelMap map) throws Exception {
		List<TestClassDirInfo> info = Constants.getTestClassesDirInfo();
		TestClassDirInfo classInfo = Constants.getTestClassDirInfo(classPath);
		map.addAttribute("dirInfo", info);
		map.addAttribute("testInfo", classInfo.getTestInfo());
		return new ModelAndView("ShowExecutedTests");

	}
	

//	public List<DirInfo> getTestClasses(String selectedClassPath) throws Exception {
//		List<DirInfo> dirInfos = new ArrayList<DirInfo>();
//		try {
//			File classDir = new File(Constants.sceensLocationPath());
//			for (File testclass : Constants.dirListByAscendingDate(classDir)) {
//				File testDir = new File(testclass.getCanonicalPath());
//				DirInfo bean = new DirInfo();
//				bean.setTestClassName(testclass.getName());
//				bean.setClassPath(testclass.getCanonicalPath());
//				List<TestInfo> testInfos = new ArrayList<TestInfo>();
//				if(StringUtils.equals(testclass.getCanonicalPath(), selectedClassPath)) {
//					for (File test : Constants.dirListByAscendingDate(testDir)) {
//						TestInfo  testInfo = new TestInfo();
//						testInfo.setName(test.getName());
//						testInfo.setPath(test.getCanonicalPath());						
//						Date dateExecuted = Constants.getLastTestExecutionDate(test.getCanonicalPath());
//						testInfo.setExecutionDate(dateExecuted);
//						testInfos.add(testInfo);
//					}
//				}
//				bean.setTestInfo(testInfos);
//				dirInfos.add(bean);
//			}
//			return dirInfos;
//		} finally {
//		}
//	}
	
	private List<TestClassDirInfo> getTestsNames(String classPath) throws Exception {
		
		try {
			List<TestClassDirInfo> dirInfos = new ArrayList<TestClassDirInfo>();
			File dir = new File(classPath);
			for (File child : Constants.dirListByAscendingDate(dir)) {

				if (".".equals(child.getName()) || "..".equals(child.getName())) {
					continue; // Ignore the self and parent aliases.\
				}
				TestClassDirInfo bean = new TestClassDirInfo();
				bean.setName(child.getName());
				bean.setPath(child.getCanonicalPath());
				Date dateExecuted = Constants.getLastTestExecutionDate(child.getCanonicalPath());
				bean.setExecutionDate(dateExecuted);
				dirInfos.add(bean);

			}
			return dirInfos;

		} finally {
		}
	}

}
