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
	
	@RequestMapping(value = "/Index", method = RequestMethod.GET)
	public ModelAndView displayTestClasses (@ModelAttribute("dirInfo") DirInfo dirInfo) throws Exception {
		return new ModelAndView("Index", "dirInfo", getTestClasses());
	}
	
	
	public List<DirInfo> getTestClasses() throws Exception {
		List<DirInfo> dirInfos = new ArrayList<DirInfo>();
		try {
			File classDir = new File(Constants.sceensLocationPath());
			for (File testclass : Constants.dirListByAscendingDate(classDir)) {
				File testDir = new File(testclass.getCanonicalPath());
				DirInfo bean = new DirInfo();
				bean.setTestClassName(testclass.getName());
				bean.setClassPath(testclass.getCanonicalPath());
//				List<TestInfo> testInfos = new ArrayList<TestInfo>();
//					for (File test : Constants.dirListByAscendingDate(testDir)) {						
//						TestInfo  testInfo = new TestInfo();
//						testInfo.setName(test.getName());
////						testInfo.setPath(test.getCanonicalPath());									
////						Date dateExecuted = DateUtils.parseDate(getTestExecutions(test.getCanonicalPath()),
////								new String[] { "dd.MM.yyyy HH-mm-ss" });
////						testInfo.setExecutionDate(dateExecuted);
//						testInfos.add(testInfo);
//						
//					}
//				bean.setTestInfo(testInfos);
				dirInfos.add(bean);
			}			
			return dirInfos;
		} finally {
		}
	}
	


}
