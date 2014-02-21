package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
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

	@RequestMapping(value="/ShowTestExecutionTime", method = RequestMethod.GET)
	public String detailTestsDisplay(@RequestParam("path") String path, ModelMap model) throws Exception {
		model.addAttribute(new DirInfoForm());
		model.addAttribute("dirInfos", getTestExecutions(path));
		return "ShowTestExecutionTime";
	
	}
	
	@RequestMapping(value="/DeleteTestExecutionTime", method = RequestMethod.GET)
	public String deleteGalery (@RequestParam("fileRoot") String fileRoot, ModelMap model) throws Exception {
		File folder = new File(fileRoot);
		FileUtils.forceDelete(folder);
		return "ShowTestExecutionTime";
	}
	
	@RequestMapping(value="/dirInfoForm", method = RequestMethod.POST)
	public ModelAndView deleteGaleryList (@ModelAttribute("dirInfoForm") DirInfoForm dirInfoForm, ModelMap model) throws Exception {
		String [] teststToDelete= dirInfoForm.getDelete();
		File folder = new File("defult");
		for (int i = 0; i < teststToDelete.length; i++) {
			folder = new File(teststToDelete[i]);
			FileUtils.forceDelete(folder);
			
		}
		if(!FileUtils.directoryContains(new File(folder.getParent()), folder)){
			FileUtils.forceDelete(new File(folder.getParent()));
		}
		
		StringBuilder sb = new StringBuilder();
		String [] path = StringUtils.split(teststToDelete[0], "\\");
		for (int i = 0; i < path.length-1; i++) {
			if(i!=0){
			sb.append("\\");
			}
			sb.append(path[i]);
		}
		String pageToLoad = sb.toString();
		
		if(StringUtils.isBlank(pageToLoad)){
			ShowExecutedTestsController con = new ShowExecutedTestsController();
			return new ModelAndView("ShowExecutedTests", "dirInfo", con.getTestsNames());
		} else {			
			model.addAttribute("dirInfos", getTestExecutions(sb.toString()));
			return new ModelAndView("ShowTestExecutionTime");
		}

	}
	
	protected List<DirInfo> getTestExecutions(String pathToDir) throws Exception {

		List<DirInfo> dirInfos = new ArrayList<DirInfo>();
		File dir = new File(pathToDir);
		for (File child : dirListByDescendingDate(dir)) {

			if (".".equals(child.getName()) || "..".equals(child.getName())) {
				continue; // Ignore the self and parent aliases.\
			}
			
			Date dateExecuted = DateUtils.parseDate(child.getName().replace("-", ":"), new String[]{"dd.MM.yyyy HH:mm:ss"});
			
			DirInfo bean = new DirInfo();			
			bean.setTestName(child.getName());
			bean.setPath(child.getCanonicalPath());
			bean.setExecutionDate(dateExecuted);
			dirInfos.add(bean);
		}
		return dirInfos;
	}

	@SuppressWarnings("unchecked")
	protected static File[] dirListByAscendingDate(File folder) {
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

