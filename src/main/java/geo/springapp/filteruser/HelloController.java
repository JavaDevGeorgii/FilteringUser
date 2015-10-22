package geo.springapp.filteruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private User user;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model ) {
		model.addAttribute("message", "Hello world!");
		user.setName("Ivanov");
		user.setPass("1234");
		user.setInfo("some info");
		RequestContextHolder.getRequestAttributes().setAttribute("user",user, RequestAttributes.SCOPE_SESSION);

		return "hello";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin(ModelMap model){
		return "login";
	}


	public void setUser(User user) {
		this.user=user;
	}
}