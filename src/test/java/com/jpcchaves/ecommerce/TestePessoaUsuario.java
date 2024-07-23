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


    Endereco enderecoEntrega = new Endereco("Rua logradouro", "55000000",
                                            "345", "complemento",
                                            "bairro tal", "PE", "Caruaru",
                                            pessoaJuridica,
                                            TipoEndereco.ENTREGA,
                                            pessoaJuridica);

    Endereco enderecoCobranca = new Endereco("Rua logradouro", "55000000",
                                             "345", "complemento",
                                             "bairro tal", "PE", "Caruaru",
                                             pessoaJuridica,
                                             TipoEndereco.COBRANCA,
                                             pessoaJuridica);

    pessoaJuridica.getEnderecos()
                  .addAll(List.of(enderecoEntrega, enderecoCobranca));

    pessoaController.salvarPJ(pessoaJuridica);
  }
}
