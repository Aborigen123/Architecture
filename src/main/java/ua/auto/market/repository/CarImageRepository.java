package ua.auto.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.auto.market.entity.CarImage;


@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Long>{

	/*@Query("SELECT c FROM  CarImage c  WHERE d.id = :id")
	CarImage findCarImageById(@Param("id") long id);*/
	@Query("delete  from  CarImage c  where c.descriptionOrder = :id")
	CarImage deleteCarImageById(@Param("id") Long id);

}
