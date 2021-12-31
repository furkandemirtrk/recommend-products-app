package com.demirturk.productrecommendapp.exception;

import com.demirturk.productrecommendapp.exception.enums.ErrorCodeEnum;
import lombok.Getter;


public class ProductRecommendAppException extends Exception{
  @Getter
  private final ErrorCodeEnum errorCodeEnum;

  public ProductRecommendAppException(ErrorCodeEnum errorCodeEnum){
    this.errorCodeEnum = errorCodeEnum;
  }
}
