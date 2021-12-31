package com.demirturk.productviewetlprocess.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Properties implements Serializable {
    @JsonProperty("productid")
    private String productId;


}
