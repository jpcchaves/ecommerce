package com.jpcchaves.ecommerce.utils;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CnpjValidatorTest {

  private static final List<String> validCnpjs =
      Collections.unmodifiableList(
          List.of("02.439.617/0001-33", "97.137.246/0001-41", "90866878000105", "93220791000146"));

  private static final List<String> invalidCnpjs =
      Collections.unmodifiableList(
          List.of(
              "02.439.617/0001-333", "97.137.246/0001-411", "908668780001055", "932207910001466"));

  @Test
  void isValid() {

    for (String validCnpj : validCnpjs) {

      assertTrue(CnpjValidator.isValid(validCnpj));
    }

    for (String invalidCnpj : invalidCnpjs) {

      assertFalse(CnpjValidator.isValid(invalidCnpj));
    }
  }
}
