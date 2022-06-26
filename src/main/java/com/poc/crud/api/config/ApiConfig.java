package com.poc.crud.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfig {

    @Value("${rest.template.connection.timeout}")
    private Integer CONNECTION_TIMEOUT;

    @Value("${rest.template.read.timeout}")
    private Integer READ_TIMEOUT;

    //@Bean(name = "appRestClient")
    @Bean
    public RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(CONNECTION_TIMEOUT);
        factory.setReadTimeout(READ_TIMEOUT);

        return new RestTemplate(factory);
    }

}
