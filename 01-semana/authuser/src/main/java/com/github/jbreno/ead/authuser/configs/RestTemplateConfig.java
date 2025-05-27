package com.github.jbreno.ead.authuser.configs;

import com.github.jbreno.ead.authuser.clients.UserClient;
import com.github.jbreno.ead.authuser.dto.CourseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestTemplateConfig {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, UserClient userClient) {

        return builder.build();
    }
}
