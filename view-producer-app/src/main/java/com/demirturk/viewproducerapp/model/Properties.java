package com.demirturk.viewproducerapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Properties implements Serializable {
    @JsonProperty("productid")
    private String productId;

    @JsonProperty("categoryid")
    private String categoryId;
}
