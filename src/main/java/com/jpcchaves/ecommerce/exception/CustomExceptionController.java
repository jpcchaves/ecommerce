package com.jpcchaves.ecommerce.exception;

import com.jpcchaves.ecommerce.model.dto.ExceptionResponseDTO;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {

  private static final Logger _logger =
      LoggerFactory.getLogger(CustomExceptionController.class);

  @ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
      Exception ex,
      Object body,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {

    _logger.error(ex.getMessage());
    _logger.error(Arrays.toString(ex.getStackTrace()));

    ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();

    StringBuilder errorMsg = new StringBuilder();

    if (ex instanceof MethodArgumentNotValidException) {

      List<ObjectError> objectErrorList =
          ((MethodArgumentNotValidException) ex).getBindingResult()
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

    return new ResponseEntity<>(exceptionResponseDTO,
                                HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // Database exceptions
  @ExceptionHandler({DataIntegrityViolationException.class,
      ConstraintViolationException.class, SQLException.class,})
  protected ResponseEntity<Object> handleExceptionDataIntegrity(Exception ex) {

    _logger.error(ex.getMessage());

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

    return new ResponseEntity<>(exceptionResponseDTO,
                                HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExceptionResponseDTO> handleEntityNotFoundException(EntityNotFoundException ex) {

    ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();

    exceptionResponseDTO.setError(ex.getMessage());
    exceptionResponseDTO.setCode(HttpStatus.NOT_FOUND.toString());

    return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DuplicateResourceException.class)
  public ResponseEntity<ExceptionResponseDTO> handleDuplicateResourceException(DuplicateResourceException ex) {

    ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();

    exceptionResponseDTO.setError(ex.getMessage());
    exceptionResponseDTO.setCode(HttpStatus.BAD_REQUEST.toString());

    return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ExceptionResponseDTO> handleBadRequestException(BadRequestException ex) {

    ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();

    exceptionResponseDTO.setError(ex.getMessage());
    exceptionResponseDTO.setCode(HttpStatus.BAD_REQUEST.toString());

    return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
  }
}
