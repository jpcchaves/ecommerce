package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.exception.BadRequestException;
import com.jpcchaves.ecommerce.model.PessoaJuridica;
import com.jpcchaves.ecommerce.model.Usuario;
import com.jpcchaves.ecommerce.repository.PessoaRepository;
import com.jpcchaves.ecommerce.repository.UsuarioRepository;
import com.jpcchaves.ecommerce.service.EmailService;
import com.jpcchaves.ecommerce.service.PessoaService;
import com.jpcchaves.ecommerce.utils.EmailTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Service
public class PessoaServiceImpl implements PessoaService {

  private static final Logger logger =
      LoggerFactory.getLogger(PessoaServiceImpl.class);
  private final PessoaRepository pessoaRepository;
  private final UsuarioRepository usuarioRepository;
  private final EmailService emailService;

  public PessoaServiceImpl(
      PessoaRepository pessoaRepository,
      UsuarioRepository usuarioRepository,
      EmailService emailService
  ) {
    this.pessoaRepository = pessoaRepository;
    this.usuarioRepository = usuarioRepository;
    this.emailService = emailService;
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


    for (int i = 0; i < pessoaJuridica.getEnderecos()
                                      .size(); i++) {

      pessoaJuridica.getEnderecos()
                    .get(i)
                    .setPessoa(pessoaJuridica);

      pessoaJuridica.getEnderecos()
                    .get(i)
                    .setEmpresa(pessoaJuridica);

    }

    pessoaJuridica = pessoaRepository.save(pessoaJuridica);

    Usuario usuarioPJ = usuarioRepository.findByPessoa(pessoaJuridica.getId(),
                                                       pessoaJuridica.getEmail());

    String senha = String.valueOf(Calendar.getInstance()
                                          .getTimeInMillis());

    if (Objects.isNull(usuarioPJ)) {

      usuarioPJ = new Usuario();

      usuarioPJ.setDataAtualSenha(new Date());
      usuarioPJ.setEmpresa(pessoaJuridica);
      usuarioPJ.setPessoa(pessoaJuridica);
      usuarioPJ.setLogin(pessoaJuridica.getEmail());

      String senhaCriptografada = new BCryptPasswordEncoder(8).encode(senha);

      usuarioPJ.setSenha(senhaCriptografada);

      usuarioPJ = usuarioRepository.save(usuarioPJ);

      usuarioRepository.insereAcessoUserPj(usuarioPJ.getId());
    }

    try {

      emailService.send(
          "Acesso para loja virtual gerado",
          EmailTemplateUtil.buildConfirmationEmail(pessoaJuridica.getNome(),
                                                   pessoaJuridica.getEmail(),
                                                   senha),
          pessoaJuridica.getEmail()
      );

    } catch (MessagingException | UnsupportedEncodingException ex) {

      logger.error("An error occurred while sending the register email!");
      logger.error(ex.getMessage());
    }


    return pessoaJuridica;
  }
}
