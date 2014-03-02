package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
		map.addAttribute("classInfo", classInfo);
		return new ModelAndView("ShowExecutedTests", map);

	}
	

	@RequestMapping(value="/DeleteTest", method = RequestMethod.GET)
	public ModelAndView deleteGalery (@RequestParam("fileRoot") String fileRoot, ModelMap model) throws Exception {
		
		File testExecutionDirToDelete = new File(fileRoot);
		FileUtils.forceDelete(testExecutionDirToDelete);
		
		if (new File(testExecutionDirToDelete.getParent()).list().length <= 0 ) {
			File testDir = new File(testExecutionDirToDelete.getParent());
			FileUtils.forceDelete(testDir);
			return new ModelAndView("redirect:/app/index");
		}
		return diplayTests(new File(fileRoot).getParent(), new ModelMap());
	}
	
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
