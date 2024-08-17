package com.zubigarayjs.customer.service;

import com.zubigarayjs.customer.model.Customer;
import com.zubigarayjs.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository cr;

    private void customerNull(Customer c){
        if (c == null) {
            throw new IllegalArgumentException("Customer no puede ser nulo");
        }
    }

    @Override
    public void saveCustomer(Customer c) {
        this.customerNull(c);
        cr.save(c);
    }

    @Override
    public void deleteCustomer(Integer id) {
        cr.deleteById(id);
    }

    @Override
    public void modifyCustomer(Integer id, Customer updateCustomer) {
        updateCustomer.setId_customer(id);
        cr.save(updateCustomer);
    }

    @Override
    public Customer getCustomer(Integer id) {
        return cr.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers;
        customers = cr.findAll();
        return customers;
    }

    @Override
    public List<Customer> searchCustomer(String email, String address){
        return cr.findByEmailOrAddress(email, address);
    }
}