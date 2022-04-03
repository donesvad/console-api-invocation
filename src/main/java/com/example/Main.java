package com.example;

import static com.example.config.RestAssuredDefinition.configureAPI;
import static com.example.service.ReleasesService.getLatestRelease;
import static com.example.service.RepositoryService.getRepository;

import com.example.dto.GetReleaseDto;
import com.example.dto.GetRepositoryDto;
import java.util.Scanner;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class Main {

    public static void main(String[] args) {
        configureAPI();

        log.info("Type repository organization/repository please:");
        Scanner scanner = new Scanner(System.in);
        String repositoryName = scanner.next();

        GetRepositoryDto repository = getRepository(repositoryName);
        GetReleaseDto latestRelease = getLatestRelease(repositoryName);

        log.info(repository.getFullName());
        log.info("Stars: " + repository.getStargazersCount());
        //it was requested <number of releases>, but I'm unable to find that field
        log.info("Forks: " + repository.getForksCount());
        log.info("Last release: " + latestRelease.getHtmlUrl());
    }
}
