package com.example.demo2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDTO {

    @JsonProperty("sampleservicerq")
    private SampleServiceRq sampleServicerq;

    @Data
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class SampleServiceRq {
        private String serviceId;
        private String orderType;
        private String type;
        private String trxId;
    }
}
