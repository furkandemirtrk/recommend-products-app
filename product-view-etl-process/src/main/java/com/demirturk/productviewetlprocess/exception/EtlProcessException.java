package com.demirturk.productviewetlprocess.exception;

import com.demirturk.productviewetlprocess.exception.enums.ErrorCodeEnum;
import lombok.Getter;


public class EtlProcessException extends Exception{
  @Getter
  private final ErrorCodeEnum errorCodeEnum;

  public EtlProcessException(ErrorCodeEnum errorCodeEnum){
    this.errorCodeEnum = errorCodeEnum;
  }
}
