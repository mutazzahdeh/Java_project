package JavaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import JavaProject.models.City;

import JavaProject.repositories.CityRepository;

@Service
public class CityService {
	private CityRepository cityRepository;

	public CityService(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
		
	}
	
//	public CityService() {
//		super();
//		String[] city= {"Hebron","Ramallah","Bethlehem","Nablus","Salfit","Jerusalem","Gaza","Tubas","Tulkarem","Jenin","Albireh","Qalqilyah", "Jericho"};
//		List<City> c=findAllCity();
//		City ci=new City();
//		if(c.size()==0) {
//			for(int i=0;i<city.length;i++) {
//				ci.setName(city[i]);
//				cityRepository.save(ci);
//			}
//		}
//	}


	public City createCity(City c) {
	return cityRepository.save(c);

}
	public void createAllCity() {
		String[] city= {"Hebron","Ramallah","Bethlehem","Nablus","Salfit","Jerusalem","Gaza","Tubas","Tulkarem","Jenin","Albireh","Qalqilyah", "Jericho"};
		List<City> c=findAllCity();
		System.out.println("12@@@@@@@@@@@@@@");
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		Long x= Long.valueOf(1);
		City ci=findById(x);
		System.out.println(ci.getName());
		System.out.println(ci.getId());
		if(c.isEmpty()) {
			System.out.println("@@@@@@@@@@@@@@");
			for(int i=0;i<city.length;i++) {
				this.createCityName(city[i]);
			}
		}
		
	}
	public City createCityName(String name) {
		City ci=new City();
		ci.setName(name);
		return cityRepository.save(ci);


	}
public List<City> findAllCity(){
	return cityRepository.findAll();
	
}
public City findById(Long id) {
Optional <City> optionalCity = cityRepository.findById(id);
if(optionalCity.isPresent()) {
	return optionalCity.get();
}
return null;
}
public void deleteCity(City c) {
	cityRepository.delete(c);
}
	
	
	
}
