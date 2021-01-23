package ua.auto.market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.auto.market.entity.Customer;
import ua.auto.market.mapper.CustomerMapper;
import ua.auto.market.repository.CustomerRepository;

@Service("userDetailsService")
public class CustomerUserDetailsServiceImpl implements UserDetailsService {

	@Autowired private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
		Customer customer = customerRepository.findUserByPhoneNumber(phoneNumber);
		if(customer == null) throw new UsernameNotFoundException("User not found");
		
		return CustomerMapper.toSecurityUser(customer);
	}

}
