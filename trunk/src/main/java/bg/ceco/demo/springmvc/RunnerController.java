package bg.ceco.demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bg.ceco.demo.selenium.TestRunner;

@Controller
public class RunnerController {

	@RequestMapping(value = "/RunClass", method = RequestMethod.GET)
	public ModelAndView runClass () throws Exception {
		TestRunner.runClass();
		return null;
	}
	
}
