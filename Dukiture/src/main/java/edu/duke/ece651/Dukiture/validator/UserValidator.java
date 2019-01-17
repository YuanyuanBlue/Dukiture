package edu.duke.ece651.Dukiture.validator;

import edu.duke.ece651.Dukiture.service.UserService;
import edu.duke.ece651.Dukiture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, "Username is empty");
        if (user.getUsername().length() < 3 || user.getUsername().length() > 15) {
            errors.rejectValue("username",null,  "Please use between 3 and 15 characters.");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username",null, "Username has been registered.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Password is empty");
        if (user.getPassword().length() < 3 || user.getPassword().length() > 15) {
            errors.rejectValue("password", null, "Please use between 3 and 15 characters.");
        }

    }
}
