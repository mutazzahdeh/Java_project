package JavaProject.valedator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import JavaProject.models.Driver;

@Component
public class DriverValidator implements Validator {

	 @Override
	    public boolean supports(Class<?> clazz) {
	        return Driver.class.equals(clazz);
	    }
	    
	    @Override
	    public void validate(Object target, Errors errors) {
	    	Driver user = (Driver) target;
	        
	        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
	            errors.rejectValue("passwordConfirmation", "Match");
	        }         
	    }
}
