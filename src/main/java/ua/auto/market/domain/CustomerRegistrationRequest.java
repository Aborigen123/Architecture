package ua.auto.market.domain;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import ua.auto.market.entity.enumeration.Role;
import ua.auto.market.validator.annotation.CheckPasswordsMatch;
import ua.auto.market.validator.annotation.UniquePhoneNumber;


@CheckPasswordsMatch
public class CustomerRegistrationRequest {

	@NotEmpty(message = "can't be empty")
	private String nameCustomer;
	@NotEmpty(message = "can't be empty")
	@UniquePhoneNumber
	private String phoneNumber;
	@NotEmpty(message = "can't be empty")
	private String password;
	@NotEmpty(message = "can't be empty")
	private String passwordConfirmation;
	private Role role;
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	

	public CustomerRegistrationRequest() {}
	
	
	
}
