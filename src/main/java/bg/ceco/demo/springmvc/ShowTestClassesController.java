package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang.StringUtils;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import bg.ceco.demo.logic.ClassInfoService;
import bg.ceco.demo.logic.ProjectService;
import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.selenium.TestRunner;

@Controller
public class ShowTestClassesController {
	@Autowired
	private ClassInfoService classInfoService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/ShowTestClasses", method = RequestMethod.GET)
	public ModelAndView showClasses (@RequestParam("id") long projectid) throws Exception {	
		ModelMap map = new ModelMap();
		Project project = projectService.get(projectid);
		String name = project.getProjectName();
		byte [] jarFile = project.getTestJar();
		JarLoader.loadJar(project);
			
		return new ModelAndView("ShowTestClasses", map);
	}
	
	@RequestMapping(value = "/RunClass", method = RequestMethod.GET)
	public ModelAndView runClass (@RequestParam("qualifiedName") String qualifiedName) {
		ClassInfo classInfo = classInfoService.loadBy(qualifiedName);
		Result reslt = null;
		TestRunner runner = new TestRunner();
		try {
			 reslt = runner.runClass(classInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}		
			if (reslt.getFailureCount() == 0) {
				classInfo.setSuccess(true);
			}		
		classInfoService.update(classInfo);
		return new ModelAndView("ShowTestClasses","dirInfo", classInfoService.list());
	}
	
	
	@RequestMapping(value = "/GetTestClasses", method = RequestMethod.GET)
	public String getClasses() throws Exception {
		ModelMap map = new ModelMap();
		getAlltest();
		return "redirect:/app/ShowTestClasses";
	}
	

	
	
	private void getAlltest() throws Exception {
		FileUtils operate = new FileUtils();
		IOFileFilter fileFilter = FileFilterUtils.suffixFileFilter("java");
		Iterator<File> files = operate.iterateFiles(new File(Constants.testLocationPath()), fileFilter,
				TrueFileFilter.INSTANCE);
		while (files.hasNext()) {
			File file = (File) files.next();
			ClassInfo info = new ClassInfo();
			info.setName(file.getName());
			info.setPath(file.getCanonicalPath());
			info.setQualifiedName(constructQualifiedName(file.getCanonicalPath()));
			classInfoService.save(info);
		}
	}
	
	private String constructQualifiedName (String path) throws Exception{	
		String qualifiedName = path.replace(Constants.testLocationPath() + "\\",
				StringUtils.EMPTY).replace("\\", ".").replace(".java", StringUtils.EMPTY);
//		qualifiedName.replace("java", "class");
		return qualifiedName;
	}
}
