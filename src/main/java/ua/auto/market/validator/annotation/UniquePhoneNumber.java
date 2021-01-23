package ua.auto.market.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.auto.market.validator.validator.UniquePhoneNumberValidator;


@Target(value = { ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePhoneNumberValidator.class)
public @interface UniquePhoneNumber {
	String message() default "This number exist";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
