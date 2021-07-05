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
import JavaProject.models.Trip;
import JavaProject.models.Users;
import JavaProject.repositories.TripRepository;
import JavaProject.services.CityService;
import JavaProject.services.DriverService;
import JavaProject.services.TripService;
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
	private final TripService tripService;
	
	

	public javacontroller(CityService cityService, DriverValidator driverValidator, DriverService driverService,
			UsersService usersservice, UserValidator userValidator,TripService tripService) {
		super();
		this.cityService = cityService;
		this.driverValidator = driverValidator;
		this.driverService = driverService;
		this.usersservice = usersservice;
		this.userValidator = userValidator;
		this.tripService=tripService;
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
	public String userhome(@ModelAttribute("trip") Trip trip,HttpSession session) {
		
	if(session.getAttribute("userId") !=null) {
    		
		return "home.jsp";	
    			}else
    				return "redirect:/userlog";	
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
        	return "redirect:/driver";
        	}
    }

	 @PostMapping(value="/logdri")
	    public String loginUser(@RequestParam("email") String email, @ModelAttribute("driver") Driver driver, @RequestParam("password") String password, Model model, HttpSession session) {
	        boolean isAuthenticated = driverService.authenticateUser(email, password);
	        if(isAuthenticated) {
	        	Driver d =driverService.findByEmail(email); 
	        	session.setAttribute("user", d.getId() );
	        	return "redirect:/driver";
	        }else {
	        	model.addAttribute("error", "Invalid credentials. Try again!");
	       
	        	return "driver.jsp";
	        }
	    }

    	
    	@RequestMapping("/login")
    	public String userLogIN(@ModelAttribute("userlog") Users user, Model model, HttpSession session,@Valid @ModelAttribute("trip") Trip trip,BindingResult ros) {
    		boolean isAuthenticated = usersservice.authenticateUser(user.getEmail(), user.getPassword());
    		if(isAuthenticated) {
    			Users u = usersservice.findByEmail(user.getEmail());
    			session.setAttribute("userId", u.getId());
    			return "redirect:/userlog";
    		}
    		else {
    			
    			model.addAttribute("error", "Invalid Credentials! Please try again with the correct user information!");
    			if(session.getAttribute("userId") !=null) {
    		
			return "redirect:/test";	
    			}else
    				return "redirect:/userlog";	
    		}
    	}
    	
    	
    	@RequestMapping("/gettaxi")
    	public String getTaxi(@Valid @ModelAttribute("trip") Trip trip,BindingResult ros,Model model,HttpSession session) {
    		System.out.println(session.getAttribute("userId"));
    		if(session.getAttribute("userId") !=null) {
    	
    		if(ros.hasErrors()) {
    			return"redirect:/test";
    		}else {
    		tripService.createTrip(trip);
    		return "main.jsp";
    		}
    	}
    	else
    		return "redirect:/userlog";
    	}
    	
       	@RequestMapping("/driver")
    	public String Ta(@Valid @ModelAttribute("trip") Trip trip,Model model,HttpSession session) {
    		if(session.getAttribute("user") !=null) {
    			List<Trip> t=tripService.findAllTrip();
    			Driver d=driverService.findUserById((Long)session.getAttribute("user"));
    			
    			model.addAttribute("trips", t);
    			model.addAttribute("user", d);
    		return "home2.jsp";
    		
    	}
    	
    		return "redirect:/loginasdriver";
    	}
    	
    	
    	@RequestMapping("/logout")
    	public String logOut(HttpSession session) {
    		session.invalidate();
    		
    		return "redirect:/userlog";
    	}
    	
    	
    		
	

	

}
