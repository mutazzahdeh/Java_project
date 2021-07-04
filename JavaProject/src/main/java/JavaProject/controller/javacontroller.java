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
import JavaProject.services.CityService;
import JavaProject.services.DriverService;
import JavaProject.valedator.DriverValidator;


@Controller
public class javacontroller {
	private final CityService cityService;
	private final DriverValidator  driverValidator;
	private final DriverService driverService;
	
	public javacontroller(CityService cityService, DriverValidator driverValidator, DriverService driverService) {
		super();
		this.cityService = cityService;
		this.driverValidator = driverValidator;
		this.driverService = driverService;
	}

	@RequestMapping("/")
	public String home() {
		cityService.createAllCity();
		return "fortest.jsp";
	}
	
	@RequestMapping("/userlog")
	public String user_Log(Model model) {
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
	 @PostMapping(value="/logdri")
	    public String loginUser(@RequestParam("email") String email, @ModelAttribute("driver") Driver driver, @RequestParam("password") String password, Model model, HttpSession session) {
	        boolean isAuthenticated = driverService.authenticateUser(email, password);
	        if(isAuthenticated) {
	        	Driver d =driverService.findByEmail(email); 
	        	session.setAttribute("user", d.getId() );
	        	return "redirect:/";
	        }else {
	        	model.addAttribute("error", "Invalid credentials. Try again!");
	       
	        	return "driver.jsp";
	        }
	    }
	

}
