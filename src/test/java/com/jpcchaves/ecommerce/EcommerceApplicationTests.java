package com.jpcchaves.ecommerce;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;
import org.springframework.context.annotation.*;

@Profile("test")
@SpringBootTest(classes = EcommerceApplicationTests.class)
class EcommerceApplicationTests {

  @Test
  void main() {
    EcommerceApplication.main(new String[]{});
  }
}
