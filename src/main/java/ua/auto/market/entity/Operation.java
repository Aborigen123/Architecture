package ua.auto.market.entity;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.auto.market.entity.enumeration.Manufacture;

@Entity
@Table(name = "operation")
public class Operation extends BaseEntity{

	@Column(name = "name_product")
	private String nameProduct;
	
	private int quantity;
	
	 @Column(name = "price",columnDefinition = "DECIMAL(5,2)")
		private BigDecimal price;
	 
	 @Column(name = "data_on_storage", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	 private Date today;
	 
	 @Enumerated(EnumType.STRING)
	 private Manufacture manufacture;

	 


	 @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch =  FetchType.LAZY) 
		@JoinColumn(name = "product_on_sell_id", nullable = true)
	private ProductOnSell productOnSell;

	 
	 @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "customer_id", nullable = true)
	private Customer customer;


	public Operation(String nameProduct, int quantity, BigDecimal price, Date today, Manufacture manufacture,
		 ProductOnSell productOnSell, Customer customer) {
		super();
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.price = price;
		this.today = today;
		this.manufacture = manufacture;
	
		this.productOnSell = productOnSell;
		this.customer = customer;
	}


	public String getNameProduct() {
		return nameProduct;
	}


	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public Date getToday() {
		return today;
	}


	public void setToday(Date today) {
		this.today = today;
	}


	public Manufacture getManufacture() {
		return manufacture;
	}


	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}


	

	public ProductOnSell getProductOnSell() {
		return productOnSell;
	}


	public void setProductOnSell(ProductOnSell productOnSell) {
		this.productOnSell = productOnSell;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Operation [nameProduct=" + nameProduct + ", quantity=" + quantity + ", price=" + price + ", today="
				+ today + ", manufacture=" + manufacture + ", customer=" + customer + ", getId()=" + getId() + "]";
	}
	 
	 
}
