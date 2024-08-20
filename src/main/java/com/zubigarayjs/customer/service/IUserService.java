package com.zubigarayjs.customer.service;

import com.zubigarayjs.customer.model.User;

import java.util.List;

public interface IUserService {

    void saveUser(User c);

    void deleteUser(Integer id);

    void modifyUser(Integer id, User c);

    User getUser(Integer id);

    List<User> getUsers();

    List<User> searchUser(String email, String address);
}