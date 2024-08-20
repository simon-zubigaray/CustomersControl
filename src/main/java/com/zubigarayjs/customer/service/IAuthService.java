package com.zubigarayjs.customer.service;

import com.zubigarayjs.customer.model.User;

public interface IAuthService {
    User login(String email, String password);
}
