//package bg.ceco.demo.struts;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;
//import org.apache.struts.actions.DispatchAction;
//import org.aspectj.util.FileUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import bg.ceco.demo.logic.AdministrationService;
//
//public class ShowExecutedTestsAction extends DispatchAction {
//
//	private static final String SCREENS_LOCATION = "\\src\\main\\webapp\\screenshots";
//	private static final String GALERY_INDEX_LOCATION = "\\src\\main\\webapp\\Galery.html";
//	private static final String TAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t";
//	private static final String URL = "http://localhost:8080/screenshots/";
//	private static final String FORWARD_SUCCESS = "success";
//	
//	@Autowired
//	private AdministrationService adminService;
//
//	private String message;
//
//	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//
//		// Collection<Person> listMembers = adminService.listMembers();
//		// for (Person person : listMembers) {
//		// System.out.println(person.getPermission());
//		// }
//		// request.setAttribute("members", listMembers);
//	//	ShowTestExecutionTimeAction  lastExecutionTime = new ShowTestExecutionTimeAction();
//	//	List<DirInfo> path = lastExecutionTime.getTestExecutions(bean.getPath());
//	//	request.setAttribute("lastExecutionTime", );
//		request.setAttribute("dirInfos", getTestsNames());
//		
//		// message = "Message";
//		// newMethod(mapping, 6);
//		return mapping.findForward(FORWARD_SUCCESS);
//	}
//
//
//	private List<DirInfo> getTestsNames() throws Exception {
//
//		try {
//			List<DirInfo> dirInfos = new ArrayList<DirInfo>();
//			File dir = new File(sceensLocationPath());
//			for (File child : dirListByAscendingDate(dir)) {
//
//				if (".".equals(child.getName()) || "..".equals(child.getName())) {
//					continue; // Ignore the self and parent aliases.\
//				}
//				DirInfo bean = new DirInfo();
//				bean.setName(child.getName());
//				bean.setPath(child.getCanonicalPath());
//				bean.setExecutionTime(getTestExecutions(child.getCanonicalPath()));
//				dirInfos.add(bean);
//
//			}
//			return dirInfos;
//
//		} finally {
//		}
//	}
//	
//	protected String getTestExecutions(String pathToDir) throws Exception {
//
//		//List<DirInfo> dirInfos = new ArrayList<DirInfo>();
//		DirInfo bean = new DirInfo();
//		File dir = new File(pathToDir);
//		for (File child : dirListByAscendingDate(dir)) {
//
//			if (".".equals(child.getName()) || "..".equals(child.getName())) {
//				continue; // Ignore the self and parent aliases.\
//			}
//			bean.setName(child.getName());
//			bean.setPath(child.getCanonicalPath());
//			//dirInfos.add(bean);
//		}
//		return bean.getName();
//	}
//	
//	private static String sceensLocationPath() throws Exception {
//		File rootDir = new File(".");
//		String pathToFiles = rootDir.getCanonicalPath() + SCREENS_LOCATION;
//		return pathToFiles;
//	}
//
//
//	@SuppressWarnings("unchecked")
//	private static File[] dirListByAscendingDate(File folder) {
//		if (!folder.isDirectory()) {
//			return null;
//		}
//		File[] files = folder.listFiles();
//		Arrays.sort(files, new Comparator() {
//			public int compare(final Object o1, final Object o2) {
//				return new Long(((File) o1).lastModified()).compareTo(new Long(((File) o2).lastModified()));
//			}
//		});
//		return files;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public static File[] dirListByDescendingDate(File folder) {
//		if (!folder.isDirectory()) {
//			return null;
//		}
//		File files[] = folder.listFiles();
//		Arrays.sort(files, new Comparator() {
//			public int compare(final Object o1, final Object o2) {
//				return new Long(((File) o2).lastModified()).compareTo(new Long(((File) o1).lastModified()));
//			}
//		});
//		return files;
//	  } 
//	
////	private void newMethod(ActionMapping mapping, int i) {
////	System.out.println("The newly created method showMemebers -- " + i);
////	System.out.println("Message (showMemebers)=" + message);
////	System.out.println(message);
////	print(message);
////}
////
////public static void print(String str) {
////	System.out.println("(showMemebers) -Eto go i meg=ssage-to" + str);
////}
//
//}
