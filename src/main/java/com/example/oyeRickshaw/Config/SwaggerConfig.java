package com.example.oyeRickshaw.Config;
/*
 * @created 14/09/2020 - 8:01 PM
 * @project oyeRickshaw
 * @author  sheetalkumar
 */


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket swaggerConfiguration() throws IOException {

        Set<String> myset = new HashSet<>();

        myset.add("http");
        myset.add("https");

        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:8080")
                .protocols(myset)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.oyeRickshaw.Controller"))
                .build()
                .apiInfo(apiDetails());

    }

    private ApiInfo apiDetails() throws IOException {

        return new ApiInfo(
                "OyeRickshaw! APIs",
                " Sample API for OyeRickshaw!",
                "v1.0",
                "",
                "API License",
                "", "");
    }
}