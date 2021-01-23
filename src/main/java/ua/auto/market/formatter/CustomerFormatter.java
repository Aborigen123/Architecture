package ua.auto.market.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ua.auto.market.entity.Customer;

@Component
public class CustomerFormatter implements Formatter<Customer> {

	@Override
	public Customer parse(String text, Locale locale) throws ParseException {
		Customer customer = new Customer();
		customer.setId(Long.valueOf(text));
		return customer;
	}
	
	@Override
	public String print(Customer object, Locale locale)  {
		return String.valueOf(object.getId());
	}



}
