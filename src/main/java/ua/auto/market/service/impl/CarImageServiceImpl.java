package ua.auto.market.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.enumeration.Status;
import ua.auto.market.repository.CarImageRepository;
import ua.auto.market.service.CarImageService;

@Service
public class CarImageServiceImpl implements CarImageService{

	
	@Autowired private CarImageRepository carImageRepository;
	
	@Override
	public void saveCarImage(CarImage carImage) {
	 carImageRepository.save(carImage);
		
	}

	@Override
	public List<CarImage> findAllCarImage() {
		
		return carImageRepository.findAll();
	}

	@Override
	public List<CarImage> findAllCarImageAccepted() {
		return carImageRepository.findAll().stream().filter(value -> value.getDescriptionOrder().getStatus().equals("accepted")).collect(Collectors.toList());
	}

	@Override
	public CarImage findImageById(Long id) {
		
		return carImageRepository.findOne(id);
	}

	@Override
	public CarImage findCarImageById(long id) {
		
		return carImageRepository.findOne(id);
	}

	@Override
	public CarImage deleteCarImageById(Long id) {
	
		return carImageRepository.deleteCarImageById(id);
	}

}
