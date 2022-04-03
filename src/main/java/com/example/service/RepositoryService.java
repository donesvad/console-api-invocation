package com.example.service;

import static io.restassured.RestAssured.given;

import com.example.dto.GetRepositoryDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RepositoryService {

    public static GetRepositoryDto getRepository(String repository) {
        return given()
            .when()
            .get("/" + repository)
            .then().extract().as(GetRepositoryDto.class);
    }

}
