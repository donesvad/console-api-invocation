package com.example.service;

import static io.restassured.RestAssured.given;

import com.example.dto.GetReleaseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReleasesService {

    private static final String RELEASES = "/releases";
    private static final String LATEST_RELEASE = RELEASES + "/latest";

    public static GetReleaseDto getLatestRelease(String repository) {
        return given()
            .when()
            .get("/" + repository + LATEST_RELEASE)
            .then().extract().as(GetReleaseDto.class);
    }

}
