package com.master.covidservice.covidservice;

import com.master.covidservice.covidservice.model.InstitutionEntity;
import com.master.covidservice.covidservice.repository.InstitutionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootApplication
public class CovidServiceApplication {
    private static Logger logger = LoggerFactory.getLogger(CovidServiceApplication.class);

    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

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
                    "Dom zdravlja Novi Grad",
                    "id-inst-number",
                    "FBIH",
                    "KS",
                    "Sarajevo",
                    null,
                    null,
                    null
            ));

            InstitutionEntity institutionEntity2 = institutionRepository.save(new InstitutionEntity(
                    UUID.fromString("1dd22551-55f5-4ad6-97aa-9c5f716be876"),
                    "Dom zdravlja Jajce",
                    "id-inst-number-2",
                    "FBIH",
                    "SBK",
                    "Jajce",
                    null,
                    null,
                    null
            ));
            logger.info("Institution table seeded");
        };
    }

}
