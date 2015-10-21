package geo.springapp.filteruser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model ) {
		model.addAttribute("message", "Hello world!");
		RequestContextHolder.getRequestAttributes().setAttribute("user",new User("Ivanov"), RequestAttributes.SCOPE_SESSION);
		return "hello";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin(ModelMap model){
		return "login";
	}
}