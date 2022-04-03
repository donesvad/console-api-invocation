package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRepositoryDto {

    private Long id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("stargazers_count")
    private Long stargazersCount;

    @JsonProperty("forks_count")
    private Long forksCount;

}
