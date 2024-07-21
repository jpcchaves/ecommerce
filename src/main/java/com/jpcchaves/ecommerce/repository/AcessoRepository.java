package com.jpcchaves.ecommerce.repository;

import com.jpcchaves.ecommerce.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Repository
@Transactional
public interface AcessoRepository extends
    JpaRepository<Acesso, Long> {

  @Query("select a from Acesso a where upper(trim(a.descricao)) like %?1%")
  List<Acesso> findAcessoByDescricao(String descricao);
}
