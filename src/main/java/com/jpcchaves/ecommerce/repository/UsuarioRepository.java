package com.jpcchaves.ecommerce.repository;

import com.jpcchaves.ecommerce.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  @Query(value = "select u from Usuario where u.login = ?1")
  Optional<Usuario> finsUserByLogin(String login);
}
