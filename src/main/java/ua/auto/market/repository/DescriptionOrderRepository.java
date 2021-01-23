package ua.auto.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.auto.market.entity.DescriptionOrder;


@Repository
public interface DescriptionOrderRepository extends JpaRepository<DescriptionOrder, Long>,JpaSpecificationExecutor<DescriptionOrder>{
	
	/*@Query("SELECT d FROM DescriptionOrder d left join CarImage c ON d.id = c.id  WHERE d.id = :id")
	DescriptionOrder findDuscriptionOrderImageById(@Param("id") long id);*/
	@Query("SELECT d FROM DescriptionOrder d   WHERE d.customer = :id")
	List<DescriptionOrder> findProductOnSellCurrentUser(@Param("id") long id);
	
	
	@Query("SELECT d FROM DescriptionOrder d   WHERE d.status = :status")
	List<DescriptionOrder> findProductByStatus(@Param("status") String status);
}
