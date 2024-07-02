package com.jpcchaves.ecommerce.model.dto;

import java.io.*;

public class ExceptionResponseDTO implements Serializable {
  private static final long serialVersionUID = -6795519224600118257L;
  private String error;
  private String code;

  public ExceptionResponseDTO() {
  }

  public ExceptionResponseDTO(
      String error,
      String code
  ) {
    this.error = error;
    this.code = code;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
