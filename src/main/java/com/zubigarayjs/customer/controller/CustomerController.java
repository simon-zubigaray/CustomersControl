package com.zubigarayjs.customer.controller;

import com.zubigarayjs.customer.model.Customer;
import com.zubigarayjs.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private ICustomerService cs;

    //lectura de muchos objetos
    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> getCustomers() {
        List<Customer> listaCustomers;
        listaCustomers = cs.getCustomers();
        return listaCustomers;
    }

    //lectura de un objeto
    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable Integer id) {
        return cs.getCustomer(id);
    }

    //alta
    @PostMapping("/customer")
    public String saveCustomer(@RequestBody Customer c) {
        cs.saveCustomer(c);
        return "El customer ha sido creado con exito!";
    }

    //baja
    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        cs.deleteCustomer(id);
        return "El customer ha sido borrado con exito!";
    }

    //modificacion
    @PutMapping("/customer/{id_customer}")
    public String modifyCustomer(@PathVariable Integer id_customer,
                                 @RequestBody Customer updateCustomer) {

        cs.modifyCustomer(id_customer, updateCustomer);
        return "El customer ha sido modificado con exito!";
    }

    //busqueda
    @GetMapping("/customer/search")
    public List<Customer> searchCustomer(@RequestParam(name = "email", required = false) String email,
                                         @RequestParam(name = "address", required = false) String address) {
        return cs.searchCustomer(email, address);
    }
}