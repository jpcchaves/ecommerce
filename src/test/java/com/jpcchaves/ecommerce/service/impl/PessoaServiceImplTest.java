package com.jpcchaves.ecommerce.service.impl;

import com.jpcchaves.ecommerce.model.*;
import com.jpcchaves.ecommerce.repository.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.*;
import org.springframework.context.annotation.*;

import java.util.*;

@Profile("test")
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
    Mockito.when(pessoaRepository.save(pessoaFisica))
           .thenReturn(pessoaFisica);

    String message = pessoaService.create(pessoaJuridica);

    Assertions.assertEquals(PESSOA_CREATE_SUCCESS_MESSAGE, message);
  }

  private void startPessoas() {
    pessoaFisica = new PessoaFisica();

    pessoaFisica.setId(11111L);
    pessoaFisica.setNome("João");
    pessoaFisica.setEmail("joao@example.com");
    pessoaFisica.setTelefone("123456789");
    pessoaFisica.setCpf("324244");
    pessoaFisica.setDataNascimento(new Date());

    pessoaJuridica = new PessoaJuridica();

    pessoaJuridica.setId(11111333L);
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
