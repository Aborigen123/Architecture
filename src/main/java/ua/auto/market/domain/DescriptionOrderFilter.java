package ua.auto.market.domain;



public class DescriptionOrderFilter {

	private String nameProduct;


		private String typeProduct;


		private String manufacture;
	
	private int year;
	
	private int pricefrom;
	
	private int priceto;

	
	public DescriptionOrderFilter(String nameProduct, String typeProduct, String manufacture, int year, int pricefrom,
			int priceto) {
		super();
		this.nameProduct = nameProduct;
		this.typeProduct = typeProduct;
		this.manufacture = manufacture;
		this.year = year;
		this.pricefrom = pricefrom;
		this.priceto = priceto;
	}


	public String getNameProduct() {
		return nameProduct;
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


	public String getManufacture() {
		return manufacture;
	}


	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getPricefrom() {
		return pricefrom;
	}


	public void setPricefrom(int pricefrom) {
		this.pricefrom = pricefrom;
	}


	public int getPriceto() {
		return priceto;
	}


	public void setPriceto(int priceto) {
		this.priceto = priceto;
	}


	public DescriptionOrderFilter(String typeProduct) {
		this.typeProduct = typeProduct;
	}


	public DescriptionOrderFilter(int pricefrom, int priceto) {
	
		this.pricefrom = pricefrom;
		this.priceto = priceto;
	}


	public DescriptionOrderFilter(String nameProduct, String typeProduct, String manufacture, int pricefrom,
			int priceto) {
		super();
		this.nameProduct = nameProduct;
		this.typeProduct = typeProduct;
		this.manufacture = manufacture;
		this.pricefrom = pricefrom;
		this.priceto = priceto;
	}






	

	








	
	
}