package ua.auto.market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.auto.market.entity.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
@Query("SELECT c FROM Customer c WHERE c.phoneNumber = :phoneNumber")
Customer findUserByPhoneNumber(@Param ("phoneNumber") String number);

@Query("SELECT c FROM Customer c WHERE c.phoneNumber = :phoneNumber")
Customer findUserByNameCustomer(@Param ("phoneNumber") String nameCustomer);
}
