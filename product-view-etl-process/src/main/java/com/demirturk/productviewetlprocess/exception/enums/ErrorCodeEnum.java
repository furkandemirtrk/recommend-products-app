package com.demirturk.productviewetlprocess.exception.enums;

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
  CONTENT_NOT_FOUND_ERROR(1002, "Content not found.", HttpStatus.BAD_REQUEST),
  ORDER_LIST_IS_EMPTY(1003, "order list is empty.", HttpStatus.BAD_REQUEST),
  PRODUCT_LIST_IS_EMPTY(1003, "product list is empty.", HttpStatus.BAD_REQUEST);

  private int code;
  private String message;
  private HttpStatus httpStatus;
}
