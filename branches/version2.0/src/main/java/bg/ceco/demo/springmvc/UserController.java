package bg.ceco.demo.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bg.ceco.demo.logic.UserService;
import bg.ceco.demo.model.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/AddUser", method = RequestMethod.GET)
	public String showAddUser(@ModelAttribute UserForm userForm) {
		return "AddUser";
	}

	@RequestMapping(value = "/CreateUser", method = RequestMethod.POST)
	@Scope(value = "request")
	public ModelAndView addUser(@ModelAttribute("userForm") UserForm userForm) {
		User user = new User();
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setUserName(userForm.getUserName());
		user.setPassword(userForm.getPassword());
		user.setRole("admin");
		userService.save(user);
		return new ModelAndView("redirect:/app/ShowProjects");
	}
}
