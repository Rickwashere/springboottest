package com.example.demo;

import com.example.demo.model.Address;
import com.example.demo.model.Contact;
import com.example.demo.model.CreditScore;
import com.example.demo.model.Customer;
import com.example.demo.model.Email;
import com.example.demo.model.Telephone;
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
            //Create Contact Info
            //Create Emails and phone numbers
            Email e1 = new Email();
            Email e2 = new Email();

            e1.setEmailAddress("rick@gmail.com");
            e1.setPreference("Primary");

            e2.setEmailAddress("sam@gmail.com");
            e2.setPreference("Secondary");

            Telephone phone1 = new Telephone();
            Telephone phone2 = new Telephone();

            phone1.setPhoneType("cell");
            phone1.setPhone("720-242-6632");
            phone1.setPreferences("Primary");

            phone2.setPhoneType("work");
            phone2.setPhone("720-536-6562");
            phone2.setPreferences("Secondary");

            //data for con 2
            Email e3 = new Email();
            Email e4 = new Email();

            e3.setEmailAddress("rick2g@gmail.com");
            e3.setPreference("Primary");

            e4.setEmailAddress("sam22@gmail.com");
            e4.setPreference("Secondary");

            Telephone phone3 = new Telephone();
            Telephone phone4 = new Telephone();

            phone3.setPhoneType("cell");
            phone3.setPhone("720-642-3432");
            phone3.setPreferences("Primary");

            phone4.setPhoneType("work");
            phone4.setPhone("720-323-6098");
            phone4.setPreferences("Secondary");


            //Create Contact list and add Contact
            Contact con1 = new Contact(); //contact 1

            List<Email> mailList1 = new ArrayList<>();
            mailList1.add(e1);
            mailList1.add(e2);
            con1.setEmailList(mailList1);

            List<Telephone> phoneList = new ArrayList<>();
            phoneList.add(phone1);
            phoneList.add(phone2);
            con1.setPhoneList(phoneList);

            List<Contact> conList1 = new ArrayList<>();
            conList1.add(con1);

            Contact con2 = new Contact();

            List<Email> mailList2 = new ArrayList<>();
            mailList2.add(e3);
            mailList2.add(e4);
            con2.setEmailList(mailList2);

            List<Telephone> phoneList2 = new ArrayList<>();
            phoneList2.add(phone3);
            phoneList2.add(phone4);
            con2.setPhoneList(phoneList2);

            List<Contact> conList2 = new ArrayList<>();
            conList2.add(con2);


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

            c1.setContactList(conList1);



            Customer c2 = new Customer();
            c2.setName("sam");
            c2.setGender("M");
            c2.setCreditScore(cs2);
            c2.setAddressList(addList2);
            c2.setContactList(conList2);



            log.info("loading data "+ repository.save( c1));
            log.info("loading data "+ repository.save (c2));

        };
    }

}
