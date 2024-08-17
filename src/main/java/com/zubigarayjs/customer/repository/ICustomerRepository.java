package com.zubigarayjs.customer.repository;

import com.zubigarayjs.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("FROM Customer c WHERE c.email LIKE %:email% OR c.address LIKE %:address%")
    List<Customer> findByEmailOrAddress(@Param("email") String email, @Param("address") String address);
}