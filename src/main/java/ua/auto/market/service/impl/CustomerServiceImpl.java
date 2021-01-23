package ua.auto.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.auto.market.entity.Customer;
import ua.auto.market.repository.CustomerRepository;
import ua.auto.market.service.CustomerService;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public void saveCustomer(Customer customer) {

    String password = customer.getPassword();
    customer.setPassword(passwordEncoder.encode(password));
    customerRepository.save(customer);

	}

	@Override
	public Customer findCustomerById(long id) {
	
		return customerRepository.findOne(id);
	}

	@Override
	public Customer findUserByPhoneNumber(String number) {
	
		return customerRepository.findUserByPhoneNumber(number);
	}

	@Override
	public List<Customer> findAllCustomer() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer findUserByNameCustomer(String nameCustomer) {
		
		return customerRepository.findUserByNameCustomer(nameCustomer);
	}

	
}
