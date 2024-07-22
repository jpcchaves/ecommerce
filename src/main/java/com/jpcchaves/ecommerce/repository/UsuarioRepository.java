package com.jpcchaves.ecommerce.repository;

import com.jpcchaves.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  @Query(value = "SELECT * FROM Usuario u WHERE u.login = :login",
      nativeQuery = true)
  Optional<Usuario> finsUserByLogin(String login);

  @Query(
      value = "select u from Usuario u where u.pessoa.id = ?1 or u.login = ?2"
  )
  Usuario findByPessoa(
      Long id,
      String email
  );

  @Modifying
  @Transactional
  @Query(
      nativeQuery = true,
      value = "insert into usuarios_acesso(usuario_id, acesso_id) values (?1," +
          " " +
          "(select id from acesso where descricao = 'ROLE_USER'))"
  )
  void insereAcessoUserPj(Long idUser);
}
