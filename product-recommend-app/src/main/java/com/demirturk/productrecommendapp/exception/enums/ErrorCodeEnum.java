package com.demirturk.productrecommendapp.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCodeEnum{

  INTERNAL_SERVER_ERROR(1000, "Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR),
  FIELD_VALIDATION_ERROR(1001, "Field validation error.", HttpStatus.BAD_REQUEST),
  CONTENT_NOT_FOUND_ERROR(1002, "Content not found.", HttpStatus.BAD_REQUEST);

  private int code;
  private String message;
  private HttpStatus httpStatus;
}
