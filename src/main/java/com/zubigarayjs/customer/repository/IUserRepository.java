package com.zubigarayjs.customer.repository;

import com.zubigarayjs.customer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User u WHERE u.email LIKE %:email% OR u.address LIKE %:address%")
    List<User> findByEmailOrAddress(@Param("email") String email, @Param("address") String address);

    @Query("FROM User u WHERE u.email = :email AND u.password = :password")
    List<User> findByEmailAAndPassword(@Param("email") String email,
                                       @Param("password") String password);
}