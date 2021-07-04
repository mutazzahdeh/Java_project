package JavaProject.controller;



import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import JavaProject.models.Trip;

@Controller
public class javacontroller {
	@RequestMapping("/")
	public String home() {
		return "fortest.jsp";
	}
	
	@RequestMapping("/userlog")
	public String user_Log() {
		return "userlogin.jsp";
	}
	
	@RequestMapping("/loginasdriver")
	public String driver_Log() {
		return "driver.jsp";
	}
	
	@RequestMapping("/test")
	public String userhome() {
		return "home.jsp";
	}
	
	

}
