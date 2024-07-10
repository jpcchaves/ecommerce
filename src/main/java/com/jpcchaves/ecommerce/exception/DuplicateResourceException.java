package com.jpcchaves.ecommerce.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateResourceException extends RuntimeException {

  private static final long serialVersionUID = -5679767575985960049L;

  public DuplicateResourceException(String message) {
    super(message);
  }
}
