package ua.auto.market.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import ua.auto.market.domain.DescriptionOrderFilter;
import ua.auto.market.domain.ProductNameFilter;
import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.DescriptionOrder;
import ua.auto.market.entity.ProductOnSell;
import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.TypeProduct;
import ua.auto.market.repository.CarImageRepository;
import ua.auto.market.repository.DescriptionOrderRepository;
import ua.auto.market.service.DescriptionOrderService;

@Service
@Slf4j
public class DescriptionOrderServiceImpl implements DescriptionOrderService{

	@Autowired private DescriptionOrderRepository descriptionOrderRepository;
@Autowired private CarImageRepository carImageRepository;

	@Override
	public void saveDescriptionOrder(DescriptionOrder descriptionOrder, CarImage carImage) {
		
		 descriptionOrderRepository.save(descriptionOrder);
		 carImageRepository.save(carImage);
		
	}

	@Override
	public List<DescriptionOrder> findAllDescriptionOrder() {
	
		return descriptionOrderRepository.findAll();
	}

	@Override
	public Page<DescriptionOrder> findDescriptionOrderBy(Pageable pageable, DescriptionOrderFilter filter) {
		
		return descriptionOrderRepository.findAll(getSpecification(filter), pageable);
	}
	
	private Specification<DescriptionOrder> getSpecification(DescriptionOrderFilter filter){
		return new Specification<DescriptionOrder>() {

			private List<Predicate> predicateList = new ArrayList<Predicate>();
             private 	Predicate predicateDo ;
			@Override
			public Predicate toPredicate(Root<DescriptionOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			
				
          		Predicate predicateName  = cb.like(root.get("nameProduct"), "%" + filter.getNameProduct() + "%");
				Predicate predicateManufacture = cb.like(root.get("manufacture"), filter.getManufacture() );
				Predicate predicateBetweenPrice= null;
				Predicate predicateTypeProduct= null;
				
			
				
		
	
				if((filter.getManufacture()).equals("Nothing") ) { 
					predicateManufacture = null;
				}else {
					 predicateManufacture = cb.like(root.get("manufacture"), filter.getManufacture() );
				}
				
				Predicate [] listPredicate = {predicateName, predicateManufacture, predicateBetweenPrice};
				
			for(int i=0; i<listPredicate.length; i++) {
				if(listPredicate[i] != null) 		predicateList.add(listPredicate[i]);
			}
		
			if(predicateList.size() == 1)   predicateDo = cb.and(predicateList.get(0));
			if(predicateList.size() == 2) 	predicateDo = cb.and(predicateList.get(0), predicateList.get(1));
			if(predicateList.size() == 3) 	predicateDo = cb.and(predicateList.get(0),  predicateList.get(1),  predicateList.get(2));
			if(predicateList.size() == 4) 	predicateDo = cb.and(predicateList.get(0),  predicateList.get(1),  predicateList.get(2),  predicateList.get(3));
			 
			return predicateDo;
			}
		};
	}



	@Override
	public DescriptionOrder findDescriptionOrderById(long id) {
		
		return descriptionOrderRepository.findOne(id);
	}

	@Override
	public DescriptionOrder findDuscriptionOrderImageById(long id) {

		return descriptionOrderRepository.findOne(id);
	}

	@Override
	public void saveDescriptionOrderOne(DescriptionOrder descriptionOrder) {
		descriptionOrderRepository.save(descriptionOrder);
		
	}

	@Override
	public List<DescriptionOrder> findProductOnSellCurrentUser(long id) {
		
		return descriptionOrderRepository.findProductOnSellCurrentUser(id);
	}

	@Override
	public void saveDescriptionOrderOonly(DescriptionOrder descriptionOrder) {
		descriptionOrderRepository.save(descriptionOrder);
		
	}

	@Override
	public void deleteDescriptionOrderById(Long id) {
		descriptionOrderRepository.delete(id);
		
	}

	@Override
	public List<DescriptionOrder> findProductByStatus(String status) {
		
		return descriptionOrderRepository.findProductByStatus(status);
	}}