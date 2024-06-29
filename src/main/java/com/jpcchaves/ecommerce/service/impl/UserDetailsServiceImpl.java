package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.model.Usuario;
import com.jpcchaves.ecommerce.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UsuarioRepository usuarioRepository;

  public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String s)
      throws UsernameNotFoundException {

    Usuario user = usuarioRepository.finsUserByLogin(s).orElseThrow(
        () -> new UsernameNotFoundException(
            "User not found with the given email"));

    return new User(user.getUsername(), user.getPassword(),
        user.getAuthorities());
  }
}
