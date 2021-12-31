package com.demirturk.productviewetlprocess.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  private Integer code;
  private String message;
  private Date date;
}
