package com.jpcchaves.ecommerce.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CpfValidatorTest {

  private static final Logger logger = LoggerFactory.getLogger(CpfValidatorTest.class);

  private static final List<String> validCpfs =
      Collections.unmodifiableList(
          List.of("418.360.720-58", "215.146.180-79", "27090967069", "32743107006"));

  private static final List<String> invalidCpfs =
      Collections.unmodifiableList(
          List.of("418.360.720-588", "215.146.180-799", "270909670699", "327431070066"));

  @Test
  void isValid() {

    logger.info("Validating valid CPFs...");

    for (String validCpf : validCpfs) {

      assertTrue(
          CpfValidator.isValid(validCpf), () -> "CPF: " + validCpf + "didn't pass the validation");
    }

    logger.info("Validating invalid CPFs...");

    for (String invalidCpf : invalidCpfs) {

      assertFalse(CpfValidator.isValid(invalidCpf));
    }
  }
}
