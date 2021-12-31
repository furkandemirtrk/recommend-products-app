package com.demirturk.streamreaderapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
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
