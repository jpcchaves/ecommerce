package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.exception.BadRequestException;
import com.jpcchaves.ecommerce.model.PessoaJuridica;
import com.jpcchaves.ecommerce.model.Usuario;
import com.jpcchaves.ecommerce.repository.PessoaRepository;
import com.jpcchaves.ecommerce.repository.UsuarioRepository;
import com.jpcchaves.ecommerce.service.PessoaService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Service
public class PessoaServiceImpl implements PessoaService {

  private final PessoaRepository pessoaRepository;
  private final UsuarioRepository usuarioRepository;

  public PessoaServiceImpl(
      PessoaRepository pessoaRepository,
      UsuarioRepository usuarioRepository
  ) {
    this.pessoaRepository = pessoaRepository;
    this.usuarioRepository = usuarioRepository;
  }


  @Override
  public PessoaJuridica salvarPJ(PessoaJuridica pessoaJuridica) {

    if (Objects.isNull(pessoaJuridica)) {

      throw new BadRequestException("Pessoa juridica nao pode ser nulo.");
    }

    if (Objects.isNull(pessoaJuridica.getId()) && pessoaRepository.existsByCnpj(pessoaJuridica.getCnpj()) != null) {

      throw new BadRequestException("Ja existe uma pessoa juridica cadastrada" +
                                        " com o CNPJ informado");
    }

    PessoaJuridica savedPJ = pessoaRepository.save(pessoaJuridica);

    Usuario usuarioPJ = usuarioRepository.findByPessoa(savedPJ.getId(),
                                                       savedPJ.getEmail());

    if (Objects.isNull(usuarioPJ)) {

      usuarioPJ = new Usuario();

      usuarioPJ.setDataAtualSenha(new Date());
      usuarioPJ.setEmpresa(savedPJ);
      usuarioPJ.setPessoa(savedPJ);
      usuarioPJ.setLogin(pessoaJuridica.getEmail());


      String senha = String.valueOf(Calendar.getInstance()
                                            .getTimeInMillis());

      String senhaCriptografada = new BCryptPasswordEncoder(8).encode(senha);

      usuarioPJ.setSenha(senhaCriptografada);

      usuarioPJ = usuarioRepository.save(usuarioPJ);

      usuarioRepository.insereAcessoUserPj(usuarioPJ.getId());
    }

    return savedPJ;
  }
}
