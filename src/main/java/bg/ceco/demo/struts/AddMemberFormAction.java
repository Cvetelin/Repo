//package bg.ceco.demo.struts;
//
//import java.util.Collection;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.struts.action.Action;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;
//
//import bg.ceco.demo.logic.AdministrationService;
//import bg.ceco.demo.model.Permission;
//import bg.ceco.demo.model.Role;
//
//public class AddMemberFormAction extends Action {
//	
//	private static final String FORWARD_SUCCESS = "success";
//	
//	private AdministrationService adminService;
//	
//	public AddMemberFormAction(AdministrationService adminService) {
//		this.adminService = adminService;
//	}
//	
//	public ActionForward execute(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		Collection<Role> roles = adminService.listRoles();
//		if (roles == null || roles.isEmpty()){
//			adminService.initRoles();
//		}
//		request.setAttribute("roles", roles);
//		
//		Collection<Permission> permissions = adminService.listPermissions();
//		if (permissions == null || permissions.isEmpty()){
//			adminService.initPermissions();
//			//permissions = Permission.ALL_PERMISSION_TYPES;
//		}
//		request.setAttribute("permissions", permissions);
//		return mapping.findForward(FORWARD_SUCCESS);
//	}
//}
