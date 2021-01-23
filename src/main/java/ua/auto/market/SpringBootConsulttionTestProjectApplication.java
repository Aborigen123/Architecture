package ua.auto.market;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

//import com.mysql.fabric.xmlrpc.base.Data;

import ua.auto.market.entity.Customer;

import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.Role;
import ua.auto.market.repository.CustomerRepository;




@SpringBootApplication
public class SpringBootConsulttionTestProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootConsulttionTestProjectApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootConsulttionTestProjectApplication.class, args);
	addAdmin(context);
	//addStorageProduct(context);
		
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {

		String nameCustomer = "ib";
		String phoneNumber = "1";
		String password = "1";
		
		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		Customer customer = customerRepository.findUserByPhoneNumber(phoneNumber);
		if(customer == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			customer = new Customer();

			customer.setNameCustomer(nameCustomer);
			customer.setPhoneNumber(phoneNumber);
			customer.setPassword(encoder.encode(password));
			customer.setRole(Role.ROLE_ADMIN);
			
			customerRepository.save(customer);
			
		
			
		}
	}
	
	
	/*static void addUser(ConfigurableApplicationContext context) {
		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		Customer user = customerRepository.findOne((long) 1);
		
		if(user == null) {
			customerRepository.save(getUser());
		}
		
	}
	
	private static List<Customer> getUser(){
		List<Customer> user = new ArrayList<>();
		
		user.add(new Customer("Vito", 6764, "1111", Role.ROLE_USER, null, null ));
	
		
		
		return user;
	}
	
	
	static void addSticker(ConfigurableApplicationContext context) {
		StickerRepository stickerRepository = context.getBean(StickerRepository.class);
		Sticker carentity = stickerRepository.findOne(1);
		
		if(carentity == null) {
			stickerRepository.save(getStickers());
		}
		
	}
	
	private static List<Sticker> getStickers(){
		List<Sticker> sticker = new ArrayList<>();
		
		for(int i =0; i<50; i++) {
		sticker.add(new Sticker("BMW"+ i,null , StickerType.Holo, AboutSticker.Car, null, null));
		}
		
		
		return sticker;
	}*/

}