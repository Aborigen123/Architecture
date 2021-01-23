package ua.auto.market.entity.enumeration;


import lombok.Getter;

@Getter

public enum Manufacture {
	
/*	Nothing,
	Audi,
	Mercedes_Benz,
	BMW,
	Lexus,
	Ford,
	Fiat;*/
Nothing("Nothing"),
Audi("Audi"),
Mercedes_Benz("Mercedes_Benz"),
BMW("BMW"),
Lexus("Lexus"),
Ford("Ford"),
Fiat("Fiat");

private String manufacture;

public String getManufacture() {
	return manufacture;
}

public void setManufacture(String manufacture) {
	this.manufacture = manufacture;
}

private Manufacture(String manufacture) {
	this.manufacture = manufacture;
}
	
}
