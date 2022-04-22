package com.master.covidservice.covidservice;

import com.master.covidservice.covidservice.model.InstitutionEntity;
import com.master.covidservice.covidservice.repository.InstitutionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class CovidServiceApplication {
    private static Logger logger = LoggerFactory.getLogger(CovidServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CovidServiceApplication.class, args);
        System.out.println("Lejla je zakon");
    }

    @Bean
    public CommandLineRunner addData(
            InstitutionRepository institutionRepository
    ) {
        return(args) -> {

            InstitutionEntity institutionEntity = institutionRepository.save(new InstitutionEntity(
                    UUID.fromString("1dd22551-55f5-4ad6-97aa-9c5f716be275"),
                    "id-inst-number",
                    "Dom zdravlja",
                    "FBIH",
                    "KS",
                    "Sarajevo",
                    null,
                    null,
                    null
            ));
            logger.info("Institution table seeded");
        };
    }

}
