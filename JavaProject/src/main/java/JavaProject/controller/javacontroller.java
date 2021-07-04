package JavaProject.controller;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import JavaProject.models.City;
import JavaProject.models.Driver;
import JavaProject.models.Users;
import JavaProject.services.CityService;
import JavaProject.services.DriverService;
import JavaProject.services.UsersService;
import JavaProject.valedator.DriverValidator;
import JavaProject.valedator.UserValidator;


@Controller
public class javacontroller {
	private final CityService cityService;
	private final DriverValidator  driverValidator;
	private final DriverService driverService;
	private final UsersService usersservice;
	private final UserValidator userValidator;
	
	

	public javacontroller(CityService cityService, DriverValidator driverValidator, DriverService driverService,
			UsersService usersservice, UserValidator userValidator) {
		super();
		this.cityService = cityService;
		this.driverValidator = driverValidator;
		this.driverService = driverService;
		this.usersservice = usersservice;
		this.userValidator = userValidator;
	}

	@RequestMapping("/")
	public String home() {
		cityService.createAllCity();
		return "fortest.jsp";
	}
	
	@RequestMapping("/userlog")
	public String user_Log(Model model,@ModelAttribute("userlog") Users user) {
		List<City> c=cityService.findAllCity();
		model.addAttribute("city",c);
		return "userlogin.jsp";
	}
	
	@RequestMapping("/loginasdriver")
	public String driver_Log(Model model) {
		
		List<City> c=cityService.findAllCity();
		model.addAttribute("driver",new Driver());
		model.addAttribute("city",c);
		return "driver.jsp";
	}
	
	@RequestMapping("/test")
	public String userhome() {
		return "home.jsp";
	}
	
	
	@PostMapping(value="/loginasuser")
    public String registerdriver(@Valid @ModelAttribute("userlog") Users user,BindingResult result,HttpSession session, Model model) {
		userValidator.validate(user, result); 
		if(result.hasErrors()) {
		List<City> c=cityService.findAllCity();
		model.addAttribute("city",c);
		return "userlogin.jsp";
	}else{
		Users d = usersservice.registerUser(user);
		
    	session.setAttribute("user", d.getId());
    	return "redirect:/userlog";
	}
    	
    	}
	
	
    	
    	
    	
    	@PostMapping(value="/loginasdriver")
        public String registerUser(@Valid @ModelAttribute("driver") Driver driver, BindingResult result, HttpSession session, Model model) {
    		driverValidator.validate(driver, result); 
    		 
        	if(result.hasErrors()) {
        		List<City> c=cityService.findAllCity();
        		model.addAttribute("city",c);
        		return "driver.jsp";
        	}else{
        	Driver d = driverService.registerDriver(driver);
        	session.setAttribute("driverid", d.getId());
        	return "redirect:/coursers";
        	}
    }
    	
    	@RequestMapping("/login")
    	public String signIn(@ModelAttribute("userlog") Users user, Model model, HttpSession session) {
    		boolean isAuthenticated = usersservice.authenticateUser(user.getEmail(), user.getPassword());
    		if(isAuthenticated) {
    			Users u = usersservice.findByEmail(user.getEmail());
    			session.setAttribute("userId", u.getId());
    			return "redirect:/userlog";
    		}
    		else {
    			model.addAttribute("error", "Invalid Credentials! Please try again with the correct user information!");
    			return "home.jsp";	
    		}
    	}
	
	

}
