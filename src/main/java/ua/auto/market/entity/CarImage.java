package ua.auto.market.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car_image")
public class CarImage extends BaseEntity {

	@Column(name = "car_image1")
	private String carImage1;
	
	@Column(name = "car_image2")
	private String carImage2;
	
	@Column(name = "car_image3")
	private String carImage3;
	
	@Column(name = "car_image4")
	private String carImage4;
	
	@Column(name = "car_image5")
	private String carImage5;
	
	@Column(name = "car_image6")
	private String carImage6;
	
	 @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.REMOVE})
	    @JoinColumn(name = "description_order_id", nullable = true)
	    private DescriptionOrder descriptionOrder;


	 public CarImage(String carImage1, String carImage2, String carImage3, String carImage4, String carImage5,
			String carImage6, DescriptionOrder descriptionOrder) {
		super();
		this.carImage1 = carImage1;
		this.carImage2 = carImage2;
		this.carImage3 = carImage3;
		this.carImage4 = carImage4;
		this.carImage5 = carImage5;
		this.carImage6 = carImage6;
		this.descriptionOrder = descriptionOrder;
	}


	public String getCarImage1() {
		return carImage1;
	}


	public void setCarImage1(String carImage1) {
		this.carImage1 = carImage1;
	}


	public String getCarImage2() {
		return carImage2;
	}


	public void setCarImage2(String carImage2) {
		this.carImage2 = carImage2;
	}


	public String getCarImage3() {
		return carImage3;
	}


	public void setCarImage3(String carImage3) {
		this.carImage3 = carImage3;
	}


	public String getCarImage4() {
		return carImage4;
	}


	public void setCarImage4(String carImage4) {
		this.carImage4 = carImage4;
	}


	public String getCarImage5() {
		return carImage5;
	}


	public void setCarImage5(String carImage5) {
		this.carImage5 = carImage5;
	}


	public String getCarImage6() {
		return carImage6;
	}


	public void setCarImage6(String carImage6) {
		this.carImage6 = carImage6;
	}


	public DescriptionOrder getDescriptionOrder() {
		return descriptionOrder;
	}


	public void setDescriptionOrder(DescriptionOrder descriptionOrder) {
		this.descriptionOrder = descriptionOrder;
	}


	public CarImage() {};
	 
}
