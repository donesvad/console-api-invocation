package com.example.config;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RestAssuredDefinition {

    private static final String REPOSITORY = "/repos";

    public static void configureAPI() {
        RestAssured.reset();
        RestAssured.defaultParser = Parser.JSON;

        RestAssured.config = config().objectMapperConfig(objectMapperConfig()
                                                             .jackson2ObjectMapperFactory((cls, charset) -> new ObjectMapper()
                                                                 .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                                                                 .configure(FAIL_ON_UNKNOWN_PROPERTIES, false)));

        RestAssured.requestSpecification = new RequestSpecBuilder()
            .setAccept("application/vnd.github.v3+json")
            .setBaseUri("https://api.github.com")
            .setBasePath(REPOSITORY)
            .build();
    }
}
