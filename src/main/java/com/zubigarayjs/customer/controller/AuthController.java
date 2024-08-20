package com.zubigarayjs.customer.controller;

import com.zubigarayjs.customer.dto.RequestLogin;
import com.zubigarayjs.customer.model.User;
import com.zubigarayjs.customer.service.IAuthService;
import com.zubigarayjs.customer.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private IAuthService iAuthService;

    @PostMapping("/auth/login")
    public String login(@RequestBody RequestLogin request){
        String email = request.getEmail();
        String password = request.getPassword();
        User user = iAuthService.login(email, password);
        String token = JwtUtil.generateToken(user);
        return token;
    }
}
