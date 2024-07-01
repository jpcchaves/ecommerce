package com.jpcchaves.ecommerce.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcchaves.ecommerce.model.Usuario;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

  public JwtLoginFilter(
      String url,
      AuthenticationManager authenticationManager
  ) {
    super(new AntPathRequestMatcher(url));
    setAuthenticationManager(authenticationManager);
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse
  ) throws AuthenticationException, IOException, ServletException {

    Usuario usuario = new ObjectMapper().readValue(
        httpServletRequest.getInputStream(), Usuario.class);

    return getAuthenticationManager().authenticate(
        new UsernamePasswordAuthenticationToken(usuario.getLogin(),
            usuario.getPassword(),
            usuario.getAuthorities()));
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult
  ) throws IOException, ServletException {

    try {

      new JwtTokenAuthenticationService().addAuthentication(response,
          authResult.getName());

    } catch (Exception e) {

      throw new RuntimeException(e);
    }
  }
}
