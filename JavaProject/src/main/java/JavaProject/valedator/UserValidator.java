package JavaProject.valedator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import JavaProject.models.Users;

@Component
public class UserValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.equals(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        Users user = (Users) target;
        System.out.println("sss");
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
    
}
