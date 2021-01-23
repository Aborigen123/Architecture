package ua.auto.market.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.auto.market.entity.enumeration.Role;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

	@Column(name = "name_customer")
	private String nameCustomer;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	private String password;
	
	private Role role;
	
	@OneToMany(mappedBy = "customer",  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	List<DescriptionOrder> descriptionOrder = new ArrayList<>();
	
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	List<Operation> operation = new ArrayList<>();



	















public Customer(String nameCustomer, String phoneNumber, String password, Role role,
			List<DescriptionOrder> descriptionOrder, List<Operation> operation) {
		super();
		this.nameCustomer = nameCustomer;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.descriptionOrder = descriptionOrder;
		this.operation = operation;
	}







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







	public Role getRole() {
		return role;
	}







	public void setRole(Role role) {
		this.role = role;
	}







	















	public List<DescriptionOrder> getDescriptionOrder() {
		return descriptionOrder;
	}







	public void setDescriptionOrder(List<DescriptionOrder> descriptionOrder) {
		this.descriptionOrder = descriptionOrder;
	}







	public List<Operation> getOperation() {
		return operation;
	}







	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}







public Customer() {}
	
	
}
