package com.jpcchaves.ecommerce.security;

import org.slf4j.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.web.filter.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class JwtApiAuthenticacaoFilter extends GenericFilterBean {
  private static final Logger _logger = LoggerFactory.getLogger(JwtApiAuthenticacaoFilter.class);

  @Override
  public void doFilter(
      ServletRequest servletRequest,
      ServletResponse servletResponse,
      FilterChain filterChain
  ) throws IOException, ServletException {


    try {

      Authentication authentication = new JwtTokenAuthenticationService().getAuthentication(
          (HttpServletRequest) servletRequest,
          (HttpServletResponse) servletResponse);

      SecurityContextHolder.getContext()
                           .setAuthentication(authentication);

      filterChain.doFilter(servletRequest, servletResponse);

    } catch (Exception ex) {

      _logger.error(Arrays.toString(ex.getStackTrace()));
      servletResponse.getWriter()
                     .write("An unexpected error occurred! Contact the server admin: " + ex.getMessage());
    }

  }
}
