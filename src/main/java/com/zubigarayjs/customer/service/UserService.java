package com.zubigarayjs.customer.service;

import com.google.common.hash.Hashing;
import com.zubigarayjs.customer.model.User;
import com.zubigarayjs.customer.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserService implements IUserService {

    private static final String SECRET_KEY = "secret_key_is_java123";

    @Autowired
    private IUserRepository cr;

    private void userNull(User c){
        if (c == null) {
            throw new IllegalArgumentException("User no puede ser nulo");
        }
    }

    @Override
    public void saveUser(User user) {
        this.userNull(user);

        String password = user.getPassword();

        String hashPassword = Hashing
                .sha256()
                .hashString(password + SECRET_KEY, StandardCharsets.UTF_8)
                .toString();

        user.setPassword(hashPassword);
        cr.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        cr.deleteById(id);
    }

    @Override
    public void modifyUser(Integer id, User updateUser) {
        updateUser.setId_user(id);
        cr.save(updateUser);
    }

    @Override
    public User getUser(Integer id) {
        return cr.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        List<User> users;
        users = cr.findAll();
        return users;
    }

    @Override
    public List<User> searchUser(String email, String address){
        return cr.findByEmailOrAddress(email, address);
    }
}