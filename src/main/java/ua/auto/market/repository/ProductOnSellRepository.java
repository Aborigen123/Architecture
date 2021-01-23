package ua.auto.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ua.auto.market.entity.ProductOnSell;

@Repository
public interface ProductOnSellRepository extends JpaRepository<ProductOnSell, Long>,JpaSpecificationExecutor<ProductOnSell>{

}
