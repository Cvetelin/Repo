package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bg.ceco.demo.logic.ClassInfoService;
import bg.ceco.demo.model.ClassInfo;
@Controller
public class ShowExecutedClassesController {
	@Autowired
	private ClassInfoService classInfoService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView displayTestClasses (@ModelAttribute("dirInfo") ClassInfo dirInfo) throws Exception {
		return new ModelAndView("index", "dirInfo", getTestClasses());
	}
	
	
	public List<ClassInfo> getTestClasses() throws Exception {
		List<ClassInfo> dirInfos = new ArrayList<ClassInfo>();
		try {
			File classDir = new File(Constants.sceensLocationPath());
			if (classDir.length() > 0) {
				for (File testclass : Constants.dirListByAscendingDate(classDir)) {
					File testDir = new File(testclass.getCanonicalPath());
					ClassInfo bean = new ClassInfo();
					bean.setName(testclass.getName());
					bean.setPath(testclass.getCanonicalPath());
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
			}
			return dirInfos;
			
		} finally {
		}
	}
	


}
