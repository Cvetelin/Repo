package bg.ceco.demo.springmvc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logout(){
			
			Subject currentSubject = SecurityUtils.getSubject();
			if (currentSubject.getPrincipal() != null) {
				currentSubject.logout();
			}			
			return "redirect:/login.jsp";
		}
}
