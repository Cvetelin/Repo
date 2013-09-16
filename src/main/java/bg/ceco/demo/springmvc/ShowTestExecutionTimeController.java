package bg.ceco.demo.springmvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bg.ceco.demo.struts.DirInfo;

@Controller
public class ShowTestExecutionTimeController {

	@RequestMapping(value="/ShowTestExecutionTime", method = RequestMethod.GET)
	public String detailTestsDisplay(@RequestParam("path") String path, ModelMap model) throws Exception {
		model.addAttribute("dirInfos", getTestExecutions(path));
		return "ShowTestExecutionTime";
	
	}
	
	@RequestMapping(value="/DeleteTestExecutionTime", method = RequestMethod.GET)
	public String deleteGalery (@RequestParam("fileRoot") String fileRoot, ModelMap model) throws Exception {
		File folder = new File(fileRoot);
		FileUtils.forceDelete(folder);

		return "ShowTestExecutionTime";
	}
	
//	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		String path = request.getParameter("path");
//		String name = request.getParameter("name");
//		request.setAttribute("testExecutions", getTestExecutions(path));
//		return mapping.findForward(FORWARD_SUCCESS);
//	}

	protected List<DirInfo> getTestExecutions(String pathToDir) throws Exception {

		List<DirInfo> dirInfos = new ArrayList<DirInfo>();
		File dir = new File(pathToDir);
		for (File child : dirListByAscendingDate(dir)) {

			if (".".equals(child.getName()) || "..".equals(child.getName())) {
				continue; // Ignore the self and parent aliases.\
			}
			DirInfo bean = new DirInfo();
			bean.setName(child.getName());
			bean.setPath(child.getCanonicalPath());
			dirInfos.add(bean);
		}
		return dirInfos;
	}
	
	//	public ActionForward deleteGallery(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	//	HttpServletResponse response) throws Exception {
	//String path = request.getParameter("path");
	//File folder = new File(path);
	//FileUtils.forceDelete(folder);
	//return mapping.findForward(FORWARD_SUCCESS);
	//}
	//@SuppressWarnings("unchecked")
	//protected static File[] dirListByAscendingDate(File folder) {
	//if (!folder.isDirectory()) {
	//	return null;
	//}
	//File[] files = folder.listFiles();
	//Arrays.sort(files, new Comparator() {
	//	public int compare(final Object o1, final Object o2) {
	//		return new Long(((File) o1).lastModified()).compareTo(new Long(((File) o2).lastModified()));
	//	}
	//});
	//return files;
	//}
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
}

