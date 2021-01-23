package ua.auto.market.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ua.auto.market.entity.enumeration.Manufacture;

@Entity
@Table(name = "product_on_sell", indexes = @Index(columnList="name_product"))
public class ProductOnSell extends BaseEntity{

	@Column(name = "name_product")
	private String nameProduct;
	
	@Enumerated(EnumType.STRING)
	 private Manufacture manufacture;

    @OneToMany(mappedBy = "productOnSell",  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Operation> operation = new ArrayList<>();
    
    @OneToMany(mappedBy = "productOnSell",  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<DescriptionOrder> descriptionOrder = new ArrayList<>();

	public ProductOnSell(String nameProduct, Manufacture manufacture, List<Operation> operation,
			List<DescriptionOrder> descriptionOrder) {
		this.nameProduct = nameProduct;
		this.manufacture = manufacture;
		this.operation = operation;
		this.descriptionOrder = descriptionOrder;
	}
	public ProductOnSell() {
		
	}
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	public List<DescriptionOrder> getDescriptionOrder() {
		return descriptionOrder;
	}

	public void setDescriptionOrder(List<DescriptionOrder> descriptionOrder) {
		this.descriptionOrder = descriptionOrder;
	}

	@Override
	public String toString() {
		return "ProductOnSell [nameProduct=" + nameProduct + ", manufacture=" + manufacture + ", getId()=" + getId()
				+ "]";
	}
	
	
}
