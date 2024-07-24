package com.jpcchaves.ecommerce;

import com.jpcchaves.ecommerce.controller.PessoaController;
import com.jpcchaves.ecommerce.enums.TipoEndereco;
import com.jpcchaves.ecommerce.model.Endereco;
import com.jpcchaves.ecommerce.model.PessoaJuridica;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Profile("test")
@SpringBootTest
public class TestePessoaUsuario {

  @Autowired
  private PessoaController pessoaController;

  @Test
  public void testCadPessoaJuridica() throws InterruptedException {

    PessoaJuridica pessoaJuridica = new PessoaJuridica();

    pessoaJuridica.setCnpj(String.valueOf(Calendar.getInstance()
                                                  .getTimeInMillis()));
    pessoaJuridica.setNome("Teste Teste");
    pessoaJuridica.setEmail("jpcchaves@outlook.com");
    pessoaJuridica.setTelefone("81999999999");
    pessoaJuridica.setInscEstadual("81999999999");
    pessoaJuridica.setNomeFanstasia("Nome Fantasia Test");
    pessoaJuridica.setRazaoSocial("Razao Social");


    Endereco enderecoEntrega = Endereco
        .builder()
        .setRuaLogradouro("Rua Logradouro")
        .setCep("55000000")
        .setNumero("345")
        .setComplemento("Complemento")
        .setBairro("Bairro")
        .setUf("PE")
        .setCidade("Caruaru")
        .setPessoa(pessoaJuridica)
        .setEmpresa(pessoaJuridica)
        .setTipoEndereco(TipoEndereco.ENTREGA)
        .build();


    Endereco enderecoCobranca = Endereco
        .builder()
        .setRuaLogradouro("Rua Logradouro")
        .setCep("55000000")
        .setNumero("345")
        .setComplemento("Complemento")
        .setBairro("Bairro")
        .setUf("PE")
        .setCidade("Caruaru")
        .setPessoa(pessoaJuridica)
        .setEmpresa(pessoaJuridica)
        .setTipoEndereco(TipoEndereco.COBRANCA)
        .build();

    pessoaJuridica.getEnderecos()
                  .addAll(List.of(enderecoEntrega, enderecoCobranca));

    pessoaJuridica = pessoaController.salvarPJ(pessoaJuridica)
                                     .getBody();

    // await for the email service send the confirmation email
    Thread.sleep(10000);

    assertNotNull(pessoaJuridica);
    assertNotNull(pessoaJuridica.getId());

    for (Endereco endereco : pessoaJuridica.getEnderecos()) {

      assertNotNull(endereco.getId());
    }

    assertEquals(2, pessoaJuridica.getEnderecos()
                                  .size());

  }
}
