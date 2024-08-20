package com.zubigarayjs.customer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zubigarayjs.customer.model.User;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "secret_key_is_java123";
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

    public static String generateToken(User user){
        String token = JWT.create()
                            .withIssuer("Juan Simon Zubigaray")
                            .withClaim("userId", user.getId_user())
                            .withIssuedAt(new Date())
                            .withExpiresAt(getExpiresDate())
                            .sign(algorithm);
        return token;
    }

    public static String getUserIdByToken(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                                    .withIssuer("Juan Simon Zubigaray")
                                    .build();
        DecodedJWT decoded = verifier.verify(token);
        String userId = decoded.getClaim("userId").toString();
        return userId;
    }

    private static Date getExpiresDate(){
        return new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24) ); //1 día
    }
}
