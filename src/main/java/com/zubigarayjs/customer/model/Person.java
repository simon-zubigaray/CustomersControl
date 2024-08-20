package com.zubigarayjs.customer.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Person {
    private String firstname;
    private String lastname;
    private String email;
    private String address;
}
