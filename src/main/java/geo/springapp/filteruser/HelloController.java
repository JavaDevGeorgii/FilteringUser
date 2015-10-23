package geo.springapp.filteruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	public User user;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletRequest request ) {
		model.addAttribute("message", "Hello world!");
//		user.setName("Ivanov");
//		user.setPass("1234");
//		user.setInfo("some info");
//		RequestContextHolder.getRequestAttributes().setAttribute("user",user, RequestAttributes.SCOPE_SESSION);

		return "hello";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin(ModelMap model, HttpRequest request){
		user.setName("Ivanov");
		user.setPass("1234");
		user.setInfo("some info");
		((HttpServletRequest) request).getSession().setAttribute("user", user);
		return "login";
	}


	public void setUser(User user) {
		this.user=user;
	}
}