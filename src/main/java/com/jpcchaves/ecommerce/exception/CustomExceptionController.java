package com.jpcchaves.ecommerce.exception;

import com.jpcchaves.ecommerce.model.dto.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

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
}
