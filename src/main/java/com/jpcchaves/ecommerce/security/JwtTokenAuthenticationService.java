package com.jpcchaves.ecommerce.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenAuthenticationService {

  private static final long EXPIRATION_TIME_30D = 2592000000L;

  @Value("${application.security.jwt.secret-key}")
  private static String SECRET_KEY;

  private static final String TOKEN_PREFIX = "Bearer";
  private static final String HEADER_AUTHORIZATION = "Authorization";

  public void addAuthentication(HttpServletResponse response, String username)
      throws Exception {

    String jwt = Jwts.builder()
        .setSubject(username)
        .setExpiration(
            new Date(System.currentTimeMillis() + EXPIRATION_TIME_30D))
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .compact();

    String token = TOKEN_PREFIX + " " + jwt;

    response.addHeader(HEADER_AUTHORIZATION, token);

    response.getWriter().write("{\"Authorization\": \"" + token + "\" }");

  }
}
