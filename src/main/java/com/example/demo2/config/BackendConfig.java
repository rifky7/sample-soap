package com.example.demo2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("backend")
public class BackendConfig {
    private String url;
    private String sampleServiceEndpoint;

    private String soapUsername;
    private String soapPassword;
}
