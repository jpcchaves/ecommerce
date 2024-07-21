package com.jpcchaves.ecommerce;

import com.jpcchaves.ecommerce.model.PessoaJuridica;
import com.jpcchaves.ecommerce.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Profile("test")
@SpringBootTest
public class TestePessoaUsuario {

    private PessoaRepository pessoaRepository;

    @Autowired
    public TestePessoaUsuario(
            PessoaRepository pessoaRepository
    ) {
        this.pessoaRepository = pessoaRepository;
    }

    @Test
    public void testCadPessoaFisica() {

        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        pessoaJuridica.setCnpj("09075681499");
        pessoaJuridica.setNome("Teste Teste");
        pessoaJuridica.setEmail("test@test.com");
        pessoaJuridica.setTelefone("81999999999");
        pessoaJuridica.setInscEstadual("81999999999");
        pessoaJuridica.setNomeFanstasia("Nome Fantasia Test");
        pessoaJuridica.setRazaoSocial("Razao Social");

        pessoaRepository.save(pessoaJuridica);

//
//        PessoaFisica pessoaFisica = new PessoaFisica();
//
//        pessoaFisica.setCpf("09075681499");
//        pessoaFisica.setNome("Teste Teste");
//        pessoaFisica.setEmail("test@test.com");
//        pessoaFisica.setTelefone("81999999999");
//        pessoaFisica.setEmpresa(pessoaFisica.getEmpresa());
    }
}
