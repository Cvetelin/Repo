//package bg.ceco.demo.struts;
//
//import java.text.DateFormat;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.struts.action.Action;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import bg.ceco.demo.logic.AdministrationService;
//import bg.ceco.demo.model.Permission;
//import bg.ceco.demo.model.Person;
//
//@Component
//public class AddMemberAction extends Action {
//	
//	private static final String FORWARD_SUCCESS = "success";
//	
//	@Autowired
//	private AdministrationService adminService;
//	
//	public ActionForward execute(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		MemberForm strutsDemoForm = (MemberForm) form;
//		Person person = new Person();
//		person.setFirstName(strutsDemoForm.getFirstName());
//		person.setLastName(strutsDemoForm.getLastName());
//		//person.setGender(0);
//		person.setEmail(strutsDemoForm.getEmail());
//		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, getLocale(request));
//		person.setBirthDate(dateFormat.parse(strutsDemoForm.getBirthDate()));
//		person.setPassword(strutsDemoForm.getPassword());
//		Permission loadPermission = adminService.loadPermission(Long.parseLong(strutsDemoForm.getPermission()));
//		person.setPermission(loadPermission);
//		System.out.println("GOT PERMISSION : " + loadPermission.getType());
//		person.setRole(adminService.loadRole(Long.parseLong(strutsDemoForm.getRole())));
//		adminService.savePerson(person);
//		 
//		return mapping.findForward(FORWARD_SUCCESS);
//	}
//
//}
