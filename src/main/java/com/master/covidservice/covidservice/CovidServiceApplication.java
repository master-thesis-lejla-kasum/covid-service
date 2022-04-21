package com.master.covidservice.covidservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidServiceApplication.class, args);
        System.out.println("Lejla je zakon");
    }

}
