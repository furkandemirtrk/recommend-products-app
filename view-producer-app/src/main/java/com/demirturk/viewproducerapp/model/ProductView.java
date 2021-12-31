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
public class ProductView implements Serializable {
    @JsonProperty("event")
    private String event;

    @JsonProperty("messageid")
    private String messageId;

    @JsonProperty("userid")
    private String userId;

    @JsonProperty("properties")
    private Properties properties;

    @JsonProperty("context")
    private Context context;
}
