package ua.auto.market.service;

import java.util.List;

import ua.auto.market.entity.CarImage;

public interface CarImageService {

	void saveCarImage(CarImage carImage);
	
	List<CarImage> findAllCarImage();

	List<CarImage> findAllCarImageAccepted();
	
	CarImage findImageById(Long id);
	
	CarImage findCarImageById(long id);
	
	CarImage deleteCarImageById(Long id);
}
