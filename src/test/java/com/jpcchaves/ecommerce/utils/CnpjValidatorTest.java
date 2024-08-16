package com.jpcchaves.ecommerce.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CnpjValidatorTest {

  private static final Logger logger = LoggerFactory.getLogger(CnpjValidatorTest.class);

  private static final List<String> validCnpjs =
      Collections.unmodifiableList(
          List.of("02.439.617/0001-33", "97.137.246/0001-41", "90866878000105", "93220791000146"));

  private static final List<String> invalidCnpjs =
      Collections.unmodifiableList(
          List.of(
              "02.439.617/0001-333", "97.137.246/0001-411", "908668780001055", "932207910001466"));

  @Test
  void isValid() {

    logger.info("Validating valid CNPJs...");

    for (String validCnpj : validCnpjs) {

      assertTrue(
          CnpjValidator.isValid(validCnpj),
          () -> "CNPJ: " + validCnpj + "didn't pass the validation");
    }

    logger.info("Validating invalid CNPJs...");

    for (String invalidCnpj : invalidCnpjs) {

      assertFalse(CnpjValidator.isValid(invalidCnpj));
    }
  }
}
