package ua.auto.market.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.auto.market.domain.CustomerRegistrationRequest;
import ua.auto.market.entity.Customer;
import ua.auto.market.entity.enumeration.Role;


public interface CustomerMapper {

	
	public static User toSecurityUser(Customer customer) {
		return new User(customer.getPhoneNumber(), customer.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(customer.getRole())));
	}
	
	
	public static Customer registerToCustomer(CustomerRegistrationRequest customerRegistration) {
Customer customer = new Customer();
		customer.setNameCustomer(customerRegistration.getNameCustomer());
		customer.setPhoneNumber(customerRegistration.getPhoneNumber());
		customer.setPassword(customerRegistration.getPassword());
		customer.setRole(Role.ROLE_USER);
return customer;
	}
	}
