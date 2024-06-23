package com.jpcchaves.ecommerce.repository;

import com.jpcchaves.ecommerce.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AcessoRepository extends
    JpaRepository<Acesso, Long> {

}
