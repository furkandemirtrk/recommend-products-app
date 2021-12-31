package com.demirturk.productrecommendapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@Document("productView")
public class ProductView implements Serializable {
    @JsonProperty("productviewid")
    private String id;

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
