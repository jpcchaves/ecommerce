package com.jpcchaves.ecommerce.exception;

public class EntityNotFoundException extends Exception {
  private static final long serialVersionUID = 5103130723175185754L;

  public EntityNotFoundException(String message) {
    super(message);
  }
}
