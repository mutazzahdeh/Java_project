package JavaProject.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import JavaProject.models.Driver;
import JavaProject.repositories.DriverRepository;
@Service
public class DriverService {
	private final DriverRepository driverRepository;
	
	
	
    public DriverService(DriverRepository driverRepository) {
		super();
		this.driverRepository = driverRepository;
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

}
