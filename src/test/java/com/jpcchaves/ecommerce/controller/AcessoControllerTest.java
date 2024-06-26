package com.jpcchaves.ecommerce.controller;

import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.jpcchaves.ecommerce.model.*;
import com.jpcchaves.ecommerce.repository.*;
import com.jpcchaves.ecommerce.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AcessoControllerTest {

  private final ObjectMapper objectMapper = ObjectMapperUtil.getInstance();
  @Autowired
  AcessoRepository acessoRepository;
  @Autowired
  private AcessoController acessoController;
  @Autowired
  private WebApplicationContext applicationContext;

  @Test
  public void testRestApiCadastroAcesso() throws Exception {

    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.applicationContext);

    MockMvc mockMvc = builder.build();

    Acesso acesso = new Acesso();

    acesso.setDescricao("ROLE_TEST");


    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                                                      .request(HttpMethod.POST, "/api/v1/acessos")
                                                      .content(objectMapper.writeValueAsString(acesso))
                                                      .accept(MediaType.APPLICATION_JSON)
                                                      .contentType(MediaType.APPLICATION_JSON));

    Acesso returnObject = objectMapper
        .reader()
        .forType(Acesso.class)
        .readValue(resultActions.andReturn()
                                .getResponse()
                                .getContentAsString());


    assertNotNull(returnObject.getId());

    assertEquals(acesso.getDescricao(), returnObject.getDescricao());
  }

  @Test
  public void testRestApiDeleteAcesso() throws Exception {

    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.applicationContext);

    MockMvc mockMvc = builder.build();

    Acesso acesso = new Acesso();

    acesso.setDescricao("ROLE_TEST_DELETE");

    acesso = acessoRepository.save(acesso);

    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                                                      .request(HttpMethod.DELETE, "/api/v1/acessos/" + acesso.getId())
                                                      .accept(MediaType.APPLICATION_JSON)
                                                      .contentType(MediaType.APPLICATION_JSON));

    int statusCode = resultActions.andReturn()
                                  .getResponse()
                                  .getStatus();


    assertEquals(HttpStatus.NO_CONTENT.value(), statusCode);
  }

  @Test
  public void testRestApiGetById() throws Exception {

    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.applicationContext);

    MockMvc mockMvc = builder.build();

    Acesso acesso = new Acesso();

    acesso.setDescricao("ROLE_TEST_BY_ID");

    acesso = acessoRepository.save(acesso);

    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                                                      .request(HttpMethod.GET, "/api/v1/acessos/" + acesso.getId())
                                                      .accept(MediaType.APPLICATION_JSON)
                                                      .contentType(MediaType.APPLICATION_JSON));

    Acesso returnObject = objectMapper
        .reader()
        .forType(Acesso.class)
        .readValue(resultActions.andReturn()
                                .getResponse()
                                .getContentAsString());

    int statusCode = resultActions.andReturn()
                                  .getResponse()
                                  .getStatus();


    assertEquals(acesso.getDescricao(), returnObject.getDescricao());

    assertNotNull(returnObject);

    assertEquals(HttpStatus.OK.value(), statusCode);
  }

  @Test
  public void testRestApiGetByDesc() throws Exception {

    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.applicationContext);

    MockMvc mockMvc = builder.build();

    Acesso acesso = new Acesso();

    acesso.setDescricao("ROLE_TEST_OBTER_LIST");

    acesso = acessoRepository.save(acesso);

    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                                                      .request(HttpMethod.GET, "/api/v1/acessos/?desc=OBTER_LIST")
                                                      .accept(MediaType.APPLICATION_JSON)
                                                      .contentType(MediaType.APPLICATION_JSON));

    List<Acesso> returnObject = objectMapper
        .readValue(resultActions.andReturn()
                                .getResponse()
                                .getContentAsString(), new TypeReference<>() {
        });

    int statusCode = resultActions.andReturn()
                                  .getResponse()
                                  .getStatus();

    assertEquals(1, returnObject.size());

    assertEquals(acesso.getDescricao(), returnObject.get(0)
                                                    .getDescricao());
    
    assertEquals(HttpStatus.OK.value(), statusCode);

    acessoRepository.deleteById(acesso.getId());
  }
}
