//package bg.ceco.demo.struts;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.struts.action.Action;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import bg.ceco.demo.logic.OrgAdminService;
//
//public class ShowDepartementsAction extends Action {
//	
//	private static final String FORWARD_SUCCESS = "success";
//	
//	@Autowired
//	private OrgAdminService adminService;
//	
//	public ActionForward execute(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		request.setAttribute("orgs", adminService.listDepsWithInactiveServices());
//		return mapping.findForward(FORWARD_SUCCESS); 
//	}
//}
