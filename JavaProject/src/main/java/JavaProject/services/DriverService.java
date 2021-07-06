package JavaProject.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import JavaProject.models.Driver;
import JavaProject.models.Trip;
import JavaProject.repositories.DriverRepository;
import JavaProject.repositories.TripRepository;
@Service
public class DriverService {
	private final DriverRepository driverRepository;
	private final TripRepository tripRepository;
	
	
	
    public DriverService(DriverRepository driverRepository, TripRepository tripRepository) {
		super();
		this.driverRepository = driverRepository;
		this.tripRepository = tripRepository;
	}

	// register user and hash their password
    public Driver registerDriver(Driver driver) {
        String hashed = BCrypt.hashpw(driver.getPassword(), BCrypt.gensalt());
        driver.setPassword(hashed);
        return driverRepository.save(driver);
    }
    
    // find user by email
    public Driver findByEmail(String email) {
        return driverRepository.findByEmail(email);
    }
    
    // find user by id
    public Driver findUserById(Long id) {
    	Optional<Driver> d = driverRepository.findById(id);
    	
    	if(d.isPresent()) {
            return d.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
    	Driver driver = driverRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(driver == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, driver.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    //update user
    public void updateDriver(Driver driver) {
    	driverRepository.save(driver);
    }
    public void updatetrip(@Valid Trip trip, Long id) {
    	System.out.println(id);
    	Driver d =findUserById(id);
    	
    	tripRepository.save(trip);
    	System.out.print(d.getId());
    	d.getTrip().add(trip);
    	driverRepository.save(d);
   	
    	System.out.println(d.getId());
    	
    	
    }
}
