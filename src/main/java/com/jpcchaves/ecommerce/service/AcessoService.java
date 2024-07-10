package com.jpcchaves.ecommerce.service;

import com.jpcchaves.ecommerce.model.*;

import java.util.*;

public interface AcessoService {

  Acesso salvar(Acesso acesso);

  Acesso findById(Long acessoId);

  List<Acesso> findByDesc(String desc);
}
