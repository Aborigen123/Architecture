package ua.auto.market.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.auto.market.domain.DescriptionOrderFilter;
import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.DescriptionOrder;

public interface DescriptionOrderService {

	void saveDescriptionOrder(DescriptionOrder descriptionOrder, CarImage carImage);
	
	List<DescriptionOrder> findAllDescriptionOrder();
	
	//LinkedHashMap<DescriptionOrder, CarImage> findAllDescriptionOrderLinkedHashMap();
	
	Page<DescriptionOrder> findDescriptionOrderBy(Pageable pageable, DescriptionOrderFilter filter);
	
	
	List<DescriptionOrder> findProductByStatus(String status);
	
	DescriptionOrder findDescriptionOrderById(long id);
	
	DescriptionOrder findDuscriptionOrderImageById(long id);
	
	void saveDescriptionOrderOne(DescriptionOrder descriptionOrder);
	
	List<DescriptionOrder> findProductOnSellCurrentUser(long id);
	
	void saveDescriptionOrderOonly(DescriptionOrder descriptionOrder);

	void deleteDescriptionOrderById(Long id);
}
