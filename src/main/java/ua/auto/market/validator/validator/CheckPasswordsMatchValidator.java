package ua.auto.market.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.auto.market.domain.CustomerRegistrationRequest;
import ua.auto.market.validator.annotation.CheckPasswordsMatch;


@Component
public class CheckPasswordsMatchValidator implements ConstraintValidator<CheckPasswordsMatch, CustomerRegistrationRequest> {

	@Override
	public void initialize(CheckPasswordsMatch constraintAnnotation) {

	}

	@Override
	public boolean isValid(CustomerRegistrationRequest user, ConstraintValidatorContext context) {
		
		if(user.getPassword() == null || user.getPasswordConfirmation() == null) {
			return false;
		}
		
		if(user.getPassword().equals(user.getPasswordConfirmation())) {
			return true;
		}
		
		
		return false;
	}
}
