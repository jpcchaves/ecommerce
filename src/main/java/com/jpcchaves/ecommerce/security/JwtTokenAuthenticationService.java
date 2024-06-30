package com.jpcchaves.ecommerce.security;

import com.jpcchaves.ecommerce.config.ApplicationContextConfig;
import com.jpcchaves.ecommerce.model.Usuario;
import com.jpcchaves.ecommerce.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    configureCors(response);

    response.getWriter().write("{\"Authorization\": \"" + token + "\" }");

  }

  public Authentication getAuthentication(
      HttpServletRequest request,
      HttpServletResponse response
  ) {

    String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);

    if (!Objects.isNull(authorizationHeader)) {

      String token = authorizationHeader.replace(TOKEN_PREFIX, "").trim();

      String user = Jwts.parser().setSigningKey(SECRET_KEY)
          .parseClaimsJws(token).getSignature();

      if (!Objects.isNull(user)) {

        Usuario usuario = ApplicationContextConfig.getApplicationContext()
            .getBean(
                UsuarioRepository.class).finsUserByLogin(user)
            .orElseThrow(() -> new UsernameNotFoundException(""));

        return new UsernamePasswordAuthenticationToken(usuario,
            usuario.getPassword(), usuario.getAuthorities());
      }
    }

    configureCors(response);
    
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
