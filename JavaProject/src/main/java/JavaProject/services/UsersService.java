package JavaProject.services;

import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import JavaProject.models.Trip;
import JavaProject.models.Users;
import JavaProject.repositories.UsersRepository;


@Service
public class UsersService {
    private final UsersRepository userRepository;
    
    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // register user and hash their password
    public Users registerUser(Users user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public Users findUserById(Long id) {
    	Optional<Users> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        Users user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
   
    
    //update user
    public void updateUser(Users user) {
    	userRepository.save(user);
    }

	public void addTrip(@Valid Trip trip, Long id) {
		Users u=findUserById(id);
		u.getTrip().add(trip);
		userRepository.save(u);
		
	}

	
}
