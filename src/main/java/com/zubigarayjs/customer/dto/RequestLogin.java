package com.zubigarayjs.customer.dto;

import lombok.Data;

@Data
public class RequestLogin {
    private String email;
    private String password;
}
