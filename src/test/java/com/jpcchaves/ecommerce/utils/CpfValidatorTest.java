package com.jpcchaves.ecommerce.utils;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CpfValidatorTest {

  private static final List<String> validCpfs =
      Collections.unmodifiableList(
          List.of("418.360.720-58", "215.146.180-79", "27090967069", "32743107006"));

  private static final List<String> invalidCpfs =
      Collections.unmodifiableList(
          List.of("418.360.720-588", "215.146.180-799", "270909670699", "327431070066"));

  @Test
  void isValid() {

    for (String validCpf : validCpfs) {

      assertTrue(CpfValidator.isValid(validCpf));
    }

    for (String invalidCpf : invalidCpfs) {

      assertFalse(CpfValidator.isValid(invalidCpf));
    }
  }
}
