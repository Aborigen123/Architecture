package ua.auto.market.entity.enumeration;

import lombok.Getter;

@Getter
public enum TypeProduct {
/*auto,
motorcycle,
jeep,
truck;*/

	Auto("Auto"),
	Motorcycle("Motorcycle"),
	Jeep("Jeep"),
	Truck("Truck");

private String typeProduct;

public String getTypeProduct() {
	return typeProduct;
}

public void setTypeProduct(String typeProduct) {
	this.typeProduct = typeProduct;
}

private TypeProduct(String typeProduct) {
	this.typeProduct = typeProduct;
}
	

}
