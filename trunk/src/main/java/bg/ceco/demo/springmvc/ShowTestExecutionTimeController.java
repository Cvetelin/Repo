package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ShowTestExecutionTimeController {
	private String pathToTestDir;
	@RequestMapping(value="/ShowTestExecutionTime", method = RequestMethod.GET)
	public String detailTestsDisplay(@RequestParam("path") String path, ModelMap model) throws Exception {
		List<TestClassDirInfo> info = Constants.getTestClassesDirInfo();
		pathToTestDir = path;		
		TestClassDirInfo classInfo = Constants.getTestClassDirInfo(new File(path).getParent());
		model.addAttribute(new DirInfoForm());
		model.addAttribute("exectutionInfo", getTestExecutions(path));
		model.addAttribute("dirInfo", info);
		model.addAttribute("classInfo", classInfo);
		return "ShowTestExecutionTime";
	}
	
	@RequestMapping(value="/DeleteTestExecutionTime", method = RequestMethod.GET)
	public ModelAndView deleteGalery (@RequestParam("fileRoot") String fileRoot, ModelMap model) throws Exception {
		List<TestClassDirInfo> info = Constants.getTestClassesDirInfo();
		model.addAttribute("dirInfo", info);
		model.addAttribute(new DirInfoForm());
		
		File testExecutionDirToDelete = new File(fileRoot);
		FileUtils.forceDelete(testExecutionDirToDelete);
		
		if (new File(testExecutionDirToDelete.getParent()).list().length <= 0 ) {
			File testDir = new File(testExecutionDirToDelete.getParent());
			FileUtils.forceDelete(testDir);
			TestClassDirInfo classInfo = Constants.getTestClassDirInfo(testDir.getParent());
			model.addAttribute("testInfo", classInfo.getTestInfo());
			return new ModelAndView("ShowExecutedTests");
		}
		
		model.addAttribute("exectutionInfo", getTestExecutions(testExecutionDirToDelete.getParent()));		
		return new ModelAndView("ShowTestExecutionTime");
	}
	
	@RequestMapping(value="/dirInfoForm", method = RequestMethod.POST)
	public ModelAndView deleteGaleryList (@ModelAttribute("dirInfoForm") DirInfoForm dirInfoForm, ModelMap model) throws Exception {
		List<TestClassDirInfo> info = Constants.getTestClassesDirInfo();
		model.addAttribute("dirInfo", info);
		model.addAttribute(new DirInfoForm());
		
		String [] testsExecutionsDirsToDelete= dirInfoForm.getDelete();
		if(!ArrayUtils.isEmpty(testsExecutionsDirsToDelete)) {
			File testExecutionDirToDelete = new File("defult");
			for (int i = 0; i < testsExecutionsDirsToDelete.length; i++) {
				testExecutionDirToDelete = new File(testsExecutionsDirsToDelete[i]);
				FileUtils.forceDelete(testExecutionDirToDelete);
				
			}
			
			if (new File(testExecutionDirToDelete.getParent()).list().length <= 0 ) {
				File testDir = new File(testExecutionDirToDelete.getParent());
				FileUtils.forceDelete(testDir);
				
				TestClassDirInfo classInfo = Constants.getTestClassDirInfo(testDir.getParent());
				model.addAttribute("testInfo", classInfo.getTestInfo());
				return new ModelAndView("ShowExecutedTests");				
			}			
		
				model.addAttribute("exectutionInfo",getTestExecutions(testExecutionDirToDelete.getParent()));
				return new ModelAndView("ShowTestExecutionTime");
		}
		return new ModelAndView("redirect:/app/ShowTestExecutionTime", "path",  pathToTestDir);
	}
	
	protected List<TestExecDirInfo> getTestExecutions(String pathToDir) throws Exception {

		List<TestExecDirInfo> execInfos = new ArrayList<TestExecDirInfo>();
		File dir = new File(pathToDir);
		for (File child : Constants.dirListByDescendingDate(dir)) {

			if (".".equals(child.getName()) || "..".equals(child.getName())) {
				continue; // Ignore the self and parent aliases.\
			}
			
			Date dateExecuted = DateUtils.parseDate(child.getName().replace("-", ":"), new String[]{"dd.MM.yyyy HH:mm:ss"});
			
			TestExecDirInfo bean = new TestExecDirInfo();			
			bean.setName(child.getName());
			bean.setPath(child.getCanonicalPath());
			bean.setExecutionDate(dateExecuted);
			bean.setPathToParentDir(child.getParent());
			bean.setParentName(dir.getName());
			execInfos.add(bean);
		}
		return execInfos;
	}

	private List<TestClassDirInfo> getTestsNames() throws Exception {

		try {
			List<TestClassDirInfo> dirInfos = new ArrayList<TestClassDirInfo>();
			File dir = new File(Constants.sceensLocationPath());
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

