package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository){
        return args -> {
            log.info("loading data "+ repository.save( new Customer("Rick", "M")));
            log.info("loading data "+ repository.save (new Customer("Sam", "M")));
        };
    }

}
