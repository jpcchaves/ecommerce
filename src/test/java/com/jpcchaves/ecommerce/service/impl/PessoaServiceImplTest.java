package com.jpcchaves.ecommerce.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.jpcchaves.ecommerce.model.PessoaFisica;
import com.jpcchaves.ecommerce.model.PessoaJuridica;
import com.jpcchaves.ecommerce.repository.PessoaRepository;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PessoaServiceImplTest {

  private static final String PESSOA_CREATE_SUCCESS_MESSAGE = "Pessoa criada com sucesso!";
  private static final Long ID_PF = 2L;
  private static final Long ID_PJ = 3L;

  @InjectMocks
  private PessoaServiceImpl pessoaService;

  @Mock
  private PessoaRepository pessoaRepository;

  private PessoaFisica pessoaFisica;
  private PessoaJuridica pessoaJuridica;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    startPessoas();
  }

  @Test
  void whenCreateThenReturnSuccess() {

    when(pessoaRepository.save(any())).thenReturn(
        PESSOA_CREATE_SUCCESS_MESSAGE);

    String response = pessoaService.create(pessoaFisica);

    assertNotNull(response);
    assertEquals(PESSOA_CREATE_SUCCESS_MESSAGE, response);
  }

  private void startPessoas() {
    pessoaFisica = new PessoaFisica();

    pessoaFisica.setId(ID_PF);
    pessoaFisica.setNome("João");
    pessoaFisica.setEmail("joao@example.com");
    pessoaFisica.setTelefone("123456789");
    pessoaFisica.setCpf("324244");
    pessoaFisica.setDataNascimento(new Date());

    pessoaJuridica = new PessoaJuridica();

    pessoaFisica.setId(ID_PJ);
    pessoaJuridica.setRazaoSocial("Minha Empresa Ltda.");
    pessoaJuridica.setNomeFanstasia("Nome Fantasia da Minha Empresa LTDA");
    pessoaJuridica.setCnpj("12345678901234");
    pessoaJuridica.setEmail("contato@minhaempresa.com");
    pessoaJuridica.setCategoria("MEI");
    pessoaJuridica.setInscMunicipal("342432342");
    pessoaJuridica.setInscEstadual("2324234");
    pessoaJuridica.setTelefone("819999999");
  }
}
