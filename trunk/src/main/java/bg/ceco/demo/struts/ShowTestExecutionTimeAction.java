package bg.ceco.demo.struts;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ShowTestExecutionTimeAction extends Action {

	private static final String FORWARD_SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dirInfo = request.getParameter("testDir");
		request.setAttribute("testExecutions", getTestExecutions(dirInfo));
		return mapping.findForward(FORWARD_SUCCESS);
	}

	private List<DirInfo> getTestExecutions(String pathToDir) throws Exception {

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
