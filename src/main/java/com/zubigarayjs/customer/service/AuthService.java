package com.zubigarayjs.customer.service;

import com.google.common.hash.Hashing;
import com.zubigarayjs.customer.model.User;
import com.zubigarayjs.customer.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AuthService implements IAuthService{

    private static final String SECRET_KEY = "secret_key_is_java123";

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User login(String email, String password) {

        String hashPassword = Hashing
                .sha256()
                .hashString(password + SECRET_KEY, StandardCharsets.UTF_8)
                .toString();

        List<User> result = iUserRepository.findByEmailAAndPassword(email, hashPassword);

        if(result.isEmpty()){
            return null;
        } else {
            return result.get(0);
        }
    }
}
