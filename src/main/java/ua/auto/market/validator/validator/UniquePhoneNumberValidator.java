package ua.auto.market.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.auto.market.service.CustomerService;
import ua.auto.market.validator.annotation.UniquePhoneNumber;


@Component
public class UniquePhoneNumberValidator  implements ConstraintValidator<UniquePhoneNumber, String>{

	@Autowired private CustomerService customerService;
	
	@Override
	public void initialize(UniquePhoneNumber constraintAnnotation) {
	
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value== null) { 
		return false;
	}

		if(customerService.findUserByPhoneNumber(value) != null) {
			return false;
		}else {
			return true;
		}

	}
}
