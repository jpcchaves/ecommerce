package com.jpcchaves.ecommerce.security;

import com.jpcchaves.ecommerce.config.*;
import com.jpcchaves.ecommerce.model.*;
import com.jpcchaves.ecommerce.repository.*;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@Service
public class JwtTokenAuthenticationService {

  private static final long EXPIRATION_TIME_30D = 2592000000L;
  private static final String TOKEN_PREFIX = "Bearer";
  private static final String HEADER_AUTHORIZATION = "Authorization";
  @Value("${application.security.jwt.secret-key}")
  private static String SECRET_KEY;

  public void addAuthentication(
      HttpServletResponse response,
      String username
  )
      throws Exception {

    String jwt = Jwts.builder()
                     .setSubject(username)
                     .setExpiration(
                         new Date(System.currentTimeMillis() + EXPIRATION_TIME_30D))
                     .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                     .compact();

    String token = TOKEN_PREFIX + " " + jwt;

    response.addHeader(HEADER_AUTHORIZATION, token);

    configureCors(response);

    response.getWriter()
            .write("{\"Authorization\": \"" + token + "\" }");

  }

  public Authentication getAuthentication(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {

    String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);

    try {
      if (!Objects.isNull(authorizationHeader)) {

        String token = authorizationHeader.replace(TOKEN_PREFIX, "")
                                          .trim();

        String user = Jwts.parser()
                          .setSigningKey(SECRET_KEY)
                          .parseClaimsJws(token)
                          .getSignature();

        if (!Objects.isNull(user)) {

          Usuario usuario = ApplicationContextConfig.getApplicationContext()
                                                    .getBean(
                                                        UsuarioRepository.class)
                                                    .finsUserByLogin(user)
                                                    .orElseThrow(() -> new UsernameNotFoundException(""));

          return new UsernamePasswordAuthenticationToken(usuario,
                                                         usuario.getPassword(), usuario.getAuthorities());
        }
      }

    } catch (SignatureException exception) {
      response.getWriter()
              .write("Invalid Token!");
    } catch (ExpiredJwtException exception) {
      response.getWriter()
              .write("Expired Token!");
    } finally {
      configureCors(response);
    }

    return null;
  }

  private void configureCors(HttpServletResponse response) {

    if (response.getHeader("Access-Control-Allow-Origin") == null) {
      response.addHeader("Access-Control-Allow-Origin", "*");
    }

    if (response.getHeader("Access-Control-Allow-Headers") == null) {
      response.addHeader("Access-Control-Allow-Headers", "*");
    }

    if (response.getHeader("Access-Control-Request-Headers") == null) {
      response.addHeader("Access-Control-Request-Headers", "*");
    }

    if (response.getHeader("Access-Control-Allow-Methods") == null) {
      response.addHeader("Access-Control-Allow-Methodss", "*");
    }
  }
}
