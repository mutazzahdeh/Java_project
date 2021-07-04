package JavaProject.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JavaProject.models.City;
import JavaProject.services.CityService;

@Controller
public class javacontroller {
	private final CityService cityService;
	
	public javacontroller(CityService cityService) {
		super();
		this.cityService = cityService;
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
		model.addAttribute("city",c);
		return "driver.jsp";
	}
	
	@RequestMapping("/test")
	public String userhome() {
		return "home.jsp";
	}
	
	

}
