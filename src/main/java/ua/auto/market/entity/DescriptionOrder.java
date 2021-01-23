package ua.auto.market.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "description_order")
public class DescriptionOrder extends BaseEntity{

	
	@Column(name = "name_product")
	private String nameProduct;
	
	// @Enumerated(EnumType.STRING)
//	private TypeProduct typeProduct;
	@Column(name = "type_product")
	private String typeProduct;
	
	private int quantity;
	
	  @Column(name = "price",columnDefinition = "DECIMAL(5,2)")
		private BigDecimal price;
	  
	
	//  @Enumerated(EnumType.STRING)
	//	 private Manufacture manufacture;
	  
	  private String manufacture;
	  
	  
		@Column(name = "status")
		private String status;
		
	  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	  @JoinColumn(name = "product_on_sell_id", nullable = true)
	 private ProductOnSell productOnSell;
	  
	  @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	  @JoinColumn(name = "customer_id", nullable = true)
	  private Customer customer;
	  
	  @OneToMany(mappedBy = "descriptionOrder",  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
		List<CarImage> carImage = new ArrayList<>();





	public DescriptionOrder(String nameProduct, String typeProduct, int quantity, BigDecimal price, String manufacture,
			ProductOnSell productOnSell, Customer customer, List<CarImage> carImage) {
		super();
		this.nameProduct = nameProduct;
		this.typeProduct = typeProduct;
		this.quantity = quantity;
		this.price = price;
		this.manufacture = manufacture;
		this.productOnSell = productOnSell;
		this.customer = customer;
		this.carImage = carImage;
	}


	public String getNameProduct() {
		return nameProduct;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public DescriptionOrder(String nameProduct, String typeProduct, int quantity, BigDecimal price, String manufacture,
			String status, ProductOnSell productOnSell, Customer customer, List<CarImage> carImage) {
		super();
		this.nameProduct = nameProduct;
		this.typeProduct = typeProduct;
		this.quantity = quantity;
		this.price = price;
		this.manufacture = manufacture;
		this.status = status;
		this.productOnSell = productOnSell;
		this.customer = customer;
		this.carImage = carImage;
	}


	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public String getTypeProduct() {
		return typeProduct;
	}


	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
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


	public String getManufacture() {
		return manufacture;
	}


	public void setManufacture(String manufacture) {
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


	public List<CarImage> getCarImage() {
		return carImage;
	}


	public void setCarImage(List<CarImage> carImage) {
		this.carImage = carImage;
	}


	public DescriptionOrder() {}

	
	
	
	
	
	  
}
