package com.jpcchaves.ecommerce;

import com.jpcchaves.ecommerce.controller.PessoaController;
import com.jpcchaves.ecommerce.model.PessoaJuridica;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Calendar;

@Profile("test")
@SpringBootTest
public class TestePessoaUsuario {

  @Autowired
  private PessoaController pessoaController;

  @Test
  public void testCadPessoaJuridica() {

    PessoaJuridica pessoaJuridica = new PessoaJuridica();

    pessoaJuridica.setCnpj(String.valueOf(Calendar.getInstance()
                                                  .getTimeInMillis()));
    pessoaJuridica.setNome("Teste Teste");
    pessoaJuridica.setEmail(String.format("tests%s@test.com",
                                          Calendar.getInstance()
                                                  .getTimeInMillis()));
    pessoaJuridica.setTelefone("81999999999");
    pessoaJuridica.setInscEstadual("81999999999");
    pessoaJuridica.setNomeFanstasia("Nome Fantasia Test");
    pessoaJuridica.setRazaoSocial("Razao Social");

    pessoaController.salvarPJ(pessoaJuridica);
  }
}
