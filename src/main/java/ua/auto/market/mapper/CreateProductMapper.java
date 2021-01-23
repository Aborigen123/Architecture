package ua.auto.market.mapper;

import ua.auto.market.domain.CreateProduct;
import ua.auto.market.domain.CreateProduct2;
import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.DescriptionOrder;

public interface CreateProductMapper {

	public static DescriptionOrder createProductToDescriptionOrder(CreateProduct createProduct) {
		DescriptionOrder descriptionOrder = new DescriptionOrder();
		//CarImage carImage = new CarImage();
		descriptionOrder.setNameProduct(createProduct.getNameProduct());
		descriptionOrder.setPrice(createProduct.getPrice());
		descriptionOrder.setQuantity(createProduct.getQuantity());
		descriptionOrder.setManufacture(createProduct.getManufacture());
		descriptionOrder.setTypeProduct(createProduct.getTypeProduct());
	/*	carImage.setStickerImage1(createProduct.getCarImage1().getOriginalFilename());
		carImage.setStickerImage2(createProduct.getCarImage2().getOriginalFilename());
		carImage.setStickerImage3(createProduct.getCarImage3().getOriginalFilename());
		carImage.setStickerImage4(createProduct.getCarImage4().getOriginalFilename());
		carImage.setStickerImage5(createProduct.getCarImage5().getOriginalFilename());
		carImage.setStickerImage6(createProduct.getCarImage6().getOriginalFilename());*/
		//createProductToDescriptionOrder2(createProduct);
		return descriptionOrder;
	}
	
	public static CarImage createProductToDescriptionOrder2(CreateProduct createProduct) {
		CarImage carImage = new CarImage();
	
		carImage.setCarImage1(createProduct.getCarImage1().getOriginalFilename());
		carImage.setCarImage2(createProduct.getCarImage2().getOriginalFilename());
		carImage.setCarImage3(createProduct.getCarImage3().getOriginalFilename());
		carImage.setCarImage4(createProduct.getCarImage4().getOriginalFilename());
		carImage.setCarImage5(createProduct.getCarImage5().getOriginalFilename());
		carImage.setCarImage6(createProduct.getCarImage6().getOriginalFilename());
		
		return carImage;
	}
	
	
	public static DescriptionOrder createProductToDescriptionOrder3(CreateProduct2 createProduct) {
		DescriptionOrder descriptionOrder = new DescriptionOrder();
		//CarImage carImage = new CarImage();
		descriptionOrder.setId(createProduct.getId());
		descriptionOrder.setNameProduct(createProduct.getNameProduct());
		descriptionOrder.setPrice(createProduct.getPrice());
		descriptionOrder.setQuantity(createProduct.getQuantity());
		descriptionOrder.setManufacture(createProduct.getManufacture());
		descriptionOrder.setTypeProduct(createProduct.getTypeProduct());
	/*	carImage.setStickerImage1(createProduct.getCarImage1().getOriginalFilename());
		carImage.setStickerImage2(createProduct.getCarImage2().getOriginalFilename());
		carImage.setStickerImage3(createProduct.getCarImage3().getOriginalFilename());
		carImage.setStickerImage4(createProduct.getCarImage4().getOriginalFilename());
		carImage.setStickerImage5(createProduct.getCarImage5().getOriginalFilename());
		carImage.setStickerImage6(createProduct.getCarImage6().getOriginalFilename());*/
		//createProductToDescriptionOrder2(createProduct);
		return descriptionOrder;
	}
	
	public static CarImage createProductToDescriptionOrder4(CreateProduct2 createProduct) {
		CarImage carImage = new CarImage();
	
		carImage.setCarImage1(createProduct.getCarImage1().getOriginalFilename());
		carImage.setCarImage2(createProduct.getCarImage2().getOriginalFilename());
		carImage.setCarImage3(createProduct.getCarImage3().getOriginalFilename());
		carImage.setCarImage4(createProduct.getCarImage4().getOriginalFilename());
		carImage.setCarImage5(createProduct.getCarImage5().getOriginalFilename());
		carImage.setCarImage6(createProduct.getCarImage6().getOriginalFilename());
		
		return carImage;
	}
}
