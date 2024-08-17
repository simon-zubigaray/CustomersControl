package com.zubigarayjs.customer.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_customer;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
}
