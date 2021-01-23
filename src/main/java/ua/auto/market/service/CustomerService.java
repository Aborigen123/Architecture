package ua.auto.market.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.auto.market.domain.ProductNameFilter;
import ua.auto.market.entity.Customer;
import ua.auto.market.entity.ProductOnSell;


public interface CustomerService {
void saveCustomer(Customer customer);

Customer findCustomerById(long id);

Customer findUserByPhoneNumber(String number);

List<Customer> findAllCustomer();

Customer findUserByNameCustomer(String nameCustomer);
}
