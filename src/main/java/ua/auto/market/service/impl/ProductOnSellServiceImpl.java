package ua.auto.market.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.auto.market.domain.ProductNameFilter;
import ua.auto.market.entity.ProductOnSell;
import ua.auto.market.repository.ProductOnSellRepository;
import ua.auto.market.service.ProductOnSellService;


@Service
public class ProductOnSellServiceImpl implements ProductOnSellService {

	@Autowired  ProductOnSellRepository productOnSellRepository;

	@Override
	public Page<ProductOnSell> findProductByName(Pageable pageable, ProductNameFilter filter) {
	
		return productOnSellRepository.findAll(getSpecification(filter), pageable);
	}
	
	private Specification<ProductOnSell> getSpecification(ProductNameFilter filter){
		return new Specification<ProductOnSell>() {

			@Override
			public Predicate toPredicate(Root<ProductOnSell> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			if(filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("nameProduct"), "%" + filter.getSearch() + "%");
			}
			
			
		};
	}
	
		

	@Override
	public void saveProductOnSell(ProductOnSell productOnSell) {
	productOnSellRepository.save(productOnSell);
		
	}

	@Override
	public List<ProductOnSell> findAllProductOnSell() {
		return productOnSellRepository.findAll();
	}

	@Override
	public Page<ProductOnSell> findAllProductOnSellByPage(Pageable pageable) {
		return null;
	}
}
