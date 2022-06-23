package com.master.covidservice.covidservice;

import com.master.covidservice.covidservice.model.ArticleEntity;
import com.master.covidservice.covidservice.model.InstitutionEntity;
import com.master.covidservice.covidservice.repository.article.ArticleRepository;
import com.master.covidservice.covidservice.repository.InstitutionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
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
            InstitutionRepository institutionRepository,
            ArticleRepository articleRepository
    ) {
        return(args) -> {

            InstitutionEntity institutionEntity = institutionRepository.save(new InstitutionEntity(
                    UUID.fromString("1dd22551-55f5-4ad6-97aa-9c5f716be275"),
                    "Dom zdravlja Novi Grad2",
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
                    "Dom zdravlja Jajce2",
                    "id-inst-number-2",
                    "FBIH",
                    "SBK",
                    "Jajce",
                    null,
                    null,
                    null
            ));

            InstitutionEntity institutionEntity3 = institutionRepository.save(new InstitutionEntity(
                    UUID.fromString("1dd22551-55f5-4ad6-97aa-9c5f716be395"),
                    "Dom zdravlja Banja Luka2",
                    "id-inst-number-3",
                    "RS",
                    null,
                    "Banja Luka",
                    null,
                    null,
                    null
            ));
            logger.info("Institution table seeded");

            ArticleEntity articleEntity1 = articleRepository.save(
                    new ArticleEntity(
                            null,
                            "Naslov 1",
                            new Date(),
                            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            false,
                            institutionEntity
                    )
            );

            ArticleEntity articleEntity2 = articleRepository.save(
                    new ArticleEntity(
                            null,
                            "Naslov 2",
                            new Date(),
                            "Lorem Ipsum is simply dummy text of the printing and try's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            true,
                            institutionEntity
                    )
            );

            ArticleEntity articleEntity3 = articleRepository.save(
                    new ArticleEntity(
                            null,
                            "Naslov 3",
                            new Date(),
                            "Loremstry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            true,
                            institutionEntity3
                    )
            );

            ArticleEntity articleEntity4 = articleRepository.save(
                    new ArticleEntity(
                            null,
                            "Naslov 4",
                            new Date(),
                            "Has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            true,
                            institutionEntity2
                    )
            );

            ArticleEntity articleEntity5 = articleRepository.save(
                    new ArticleEntity(
                            null,
                            "Naslov 5",
                            new Date(),
                            "When an unknown printer took a galley of type and scrambled it to Has been the industry's standard dummy text ever since the 1500s make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            true,
                            institutionEntity2
                    )
            );

            ArticleEntity articleEntity6 = articleRepository.save(
                    new ArticleEntity(
                            null,
                            "Naslov 6",
                            new Date(),
                            "It has survived not only five centuries. When an unknown printer took a galley of type and scrambled it to Has been the industry's standard dummy text ever since the 1500s make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            true,
                            institutionEntity3
                    )
            );

            ArticleEntity articleEntity7 = articleRepository.save(
                    new ArticleEntity(
                            null,
                            "Naslov 7",
                            new Date(),
                            "It has survived not only five centuries. When an unknown printer took a galley of type and scrambled it to Has been the industry's standard dummy text ever since the 1500s make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            true,
                            institutionEntity2
                    )
            );

            ArticleEntity articleEntity8 = articleRepository.save(
                    new ArticleEntity(
                            null,
                            "Naslov 8",
                            new Date(),
                            "It has survived not only five centuries. When an unknown printer took a galley of type and scrambled it to Has been the industry's standard dummy text ever since the 1500s make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            true,
                            institutionEntity
                    )
            );

            logger.info("Article table seeded");
        };
    }

}
