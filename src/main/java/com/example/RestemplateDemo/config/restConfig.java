package com.example.RestemplateDemo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriTemplateHandler;

import java.time.Duration;

@Configuration
public class restConfig {
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder)
    {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler("http://localhost:9193/empInfo");

       return builder.
               uriTemplateHandler(uriTemplateHandler).setReadTimeout(Duration.ofMillis(15000)).build();
    }
}
