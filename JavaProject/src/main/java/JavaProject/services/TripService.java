package JavaProject.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import JavaProject.models.Driver;
import JavaProject.models.Trip;
import JavaProject.models.Users;
import JavaProject.repositories.TripRepository;
@Service
public class TripService {
	private final TripRepository tripRepository;
	private final DriverService driverService;

	public TripService(TripRepository tripRepository, DriverService driverService) {
		super();
		this.tripRepository = tripRepository;
		this.driverService = driverService;
	}
	
	public Trip createTrip(Trip t) {
	return tripRepository.save(t);

}
public List<Trip> findAllTrip(){
	return tripRepository.findAll();
	
}
public Trip findById(Long id) {
Optional <Trip> optionalTrip = tripRepository.findById(id);
if(optionalTrip.isPresent()) {
	return optionalTrip.get();
}
return null;
}
public void deleteTrip(Trip t) {
	tripRepository.delete(t);
}
public void updateTrip(Trip t) {
tripRepository.save(t);
}
public List<Trip> findByUserContains(Users u){
	return tripRepository.findByUserContains(u);
}


}