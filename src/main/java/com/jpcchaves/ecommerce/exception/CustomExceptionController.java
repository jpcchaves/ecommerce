package com.jpcchaves.ecommerce.exception;

import com.jpcchaves.ecommerce.model.dto.*;
import org.hibernate.exception.*;
import org.springframework.dao.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

import java.sql.*;
import java.util.*;

@RestControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
      Exception ex,
      Object body,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {

    ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();

    StringBuilder errorMsg = new StringBuilder();

    if (ex instanceof MethodArgumentNotValidException) {

      List<ObjectError> objectErrorList = ((MethodArgumentNotValidException) ex).getBindingResult()
                                                                                .getAllErrors();


      for (ObjectError objectError : objectErrorList) {
        errorMsg.append(objectError.getDefaultMessage());
        errorMsg.append("\n");
      }
    } else {

      errorMsg.append(ex.getMessage());
    }

    exceptionResponseDTO.setCode(status.value() + "==>" + status.getReasonPhrase());
    exceptionResponseDTO.setError(errorMsg.toString());

    return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // Database exceptions
  @ExceptionHandler({DataIntegrityViolationException.class, ConstraintViolationException.class, SQLException.class,})
  protected ResponseEntity<Object> handleExceptionDataIntegrity(Exception ex) {

    ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();

    StringBuilder errorMsg = new StringBuilder();

    if (ex instanceof DataIntegrityViolationException) {

      errorMsg.append(ex.getCause()
                        .getMessage());

    } else if (ex instanceof ConstraintViolationException) {

      errorMsg.append(ex.getCause()
                        .getMessage());

    } else if (ex instanceof SQLException) {

      errorMsg.append(ex.getCause()
                        .getMessage());

    }

    exceptionResponseDTO.setError(errorMsg.toString());
    exceptionResponseDTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());

    return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
