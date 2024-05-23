package com.saket;

import com.saket.run.Location;
import com.saket.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now(), 4, Location.OUTDOOR );
            log.info("Run: " + run);
        };
    }

}