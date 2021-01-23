package ua.auto.market.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.auto.market.domain.ProductNameFilter;
import ua.auto.market.entity.ProductOnSell;
import ua.auto.market.entity.enumeration.Manufacture;




public interface ProductOnSellService {

	Page<ProductOnSell> findProductByName(Pageable pageable, ProductNameFilter filter);
	
	void saveProductOnSell(ProductOnSell productOnSell);
	
	List<ProductOnSell> findAllProductOnSell();
	
	Page<ProductOnSell> findAllProductOnSellByPage(Pageable pageable);
	
/*	ProductOnSell productOnSell();
@ModelAttribute("manufactures")
public List<Manufacture>  manufactureTupe(){
	return productOnSellService.findAllProductOnSell()
			.stream().map(productOnSell -> ((productOnSell) productOnSell).getManufacture()).collect(Collectors.toList());
}*/
}
