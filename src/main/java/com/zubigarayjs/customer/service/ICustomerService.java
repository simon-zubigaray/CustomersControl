package com.zubigarayjs.customer.service;

import com.zubigarayjs.customer.model.Customer;

import java.util.List;

public interface ICustomerService {

    void saveCustomer(Customer c);

    void deleteCustomer(Integer id);

    void modifyCustomer(Integer id, Customer c);

    Customer getCustomer(Integer id);

    List<Customer> getCustomers();

    List<Customer> searchCustomer(String email, String address);
}