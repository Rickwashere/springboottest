package com.example.demo;

import com.example.demo.model.Address;
import com.example.demo.model.CreditScore;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseLoader {
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository){
        return args -> {
            //Create Credit Scores
            CreditScore cs1 = new CreditScore();
            cs1.setProviderName("provider1");
            cs1.setCreditScore(500.2);

            CreditScore cs2 = new CreditScore();
            cs2.setProviderName("provider1");
            cs2.setCreditScore(300.59);

            //Create Address
            Address ad1 = new Address();
            ad1.setAddressLine1("8822 chestnut");
            ad1.setState("CO");
            ad1.setZipcode("23457");

            Address ad2 = new Address();
            ad2.setAddressLine1("8823 chestnut");
            ad2.setState("CO");
            ad2.setZipcode("23458");

            Address ad3 = new Address();
            ad3.setAddressLine1("8422 chestnut");
            ad3.setState("CO");
            ad3.setZipcode("23857");

            // Create a list and add addresses in the list
            List<Address> addList = new ArrayList<>();
            addList.add(ad1);
            addList.add(ad2);
            List<Address> addList2 = new ArrayList<>();
            addList2.add(ad3);

            //Create Customers
            Customer c1 = new Customer();
            c1.setName("rick");
            c1.setGender("M");
            c1.setCreditScore(cs1);
            c1.setAddressList(addList);

            Customer c2 = new Customer();
            c2.setName("sam");
            c2.setGender("M");
            c2.setCreditScore(cs2);
            c2.setAddressList(addList2);



            log.info("loading data "+ repository.save( c1));
            log.info("loading data "+ repository.save (c2));



        };
    }

}
