package com.zubigarayjs.customer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zubigarayjs.customer.model.User;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "secret_key_is_java123";

    public static String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        String token = JWT.create()
                            .withIssuer("Juan Simon Zubigaray")
                            .withClaim("userId", user.getId_user())
                            .withIssuedAt(new Date())
                            .withExpiresAt(getExpiresDate())
                            .sign(algorithm);
        return token;
    }

    //public User getUserByToken(String token){

    //}

    private static Date getExpiresDate(){
        return new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24) ); //1 día
    }
}
