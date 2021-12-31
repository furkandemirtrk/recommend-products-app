package com.demirturk.productrecommendapp.exception;

import com.demirturk.productrecommendapp.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest request){
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setDate(new Date());
    if (ex instanceof ProductRecommendAppException){
      errorResponse.setCode(((ProductRecommendAppException) ex).getErrorCodeEnum().getCode());
      errorResponse.setMessage(((ProductRecommendAppException) ex).getErrorCodeEnum().getMessage());
      log.error("CouponException Error", ex);
    } else {
      errorResponse.setMessage(ex.getMessage());
      errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
      log.error("INTERNAL_SERVER_ERROR Error", ex);
    }
    return new ResponseEntity<>(errorResponse , HttpStatus.EXPECTATION_FAILED);
  }
}
