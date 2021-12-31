package com.demirturk.productviewetlprocess.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Context implements Serializable {
    @JsonProperty("source")
    private String source;
}
