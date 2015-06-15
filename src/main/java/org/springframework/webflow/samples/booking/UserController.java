package org.springframework.webflow.samples.booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	private UserService userService;
 
	public UserService geteventManager() {
		return userService;
	}
 
	public void setuserService(UserService userService) {
		this.userService = userService;
	}
 
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView("home");	
		mv.addObject("home", this.userService.getUser());
		return mv;
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "name", required = false) String name,
		@RequestParam(value = "password", required = false) String password) {
 
		ModelAndView model = new ModelAndView();
		UserService userService = new UserService(name, password);
		
		if (userService.getUser() == null) {
			model.addObject("error", "Invalid username and password!");
			model.setViewName("login");
			return model;
		}
		model.addObject("user", userService.getUser());
		model.setViewName("home");
		return model;
	}
}