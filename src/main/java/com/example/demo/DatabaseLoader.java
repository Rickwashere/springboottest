package com.example.demo;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Address;
import com.example.demo.model.Contact;
import com.example.demo.model.CreditScore;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerEvent;
import com.example.demo.model.Email;
import com.example.demo.model.Event;
import com.example.demo.model.SocialMedia;
import com.example.demo.model.Telephone;
import com.example.demo.repository.CustomerQueryRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseLoader {
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository, EventRepository ER, CustomerQueryRepository cqr){
        return args -> {

            //Create Event
            Event eve1 = new Event();
            Event eve2 = new Event();
            Event eve3 = new Event();

            eve1.setEventType("Appointment");
            eve1.setDescription("outside appointment");

            eve2.setEventType("Dinner");
            eve2.setDescription("cafeteria free steak");

            eve3.setEventType("Party");
            eve3.setDescription("Formal attire not required");

            List<Event> eventList= new ArrayList<>();
            eventList.add(eve1);
            eventList.add(eve2);

            //Create Social Media
            SocialMedia sm1 = new SocialMedia();
            SocialMedia sm2 = new SocialMedia();
            SocialMedia sm3 = new SocialMedia();

            sm1.setSocialMediaName("Facebook");
            sm2.setSocialMediaName("Twitter");
            sm3.setSocialMediaName("Instagram");

            List<SocialMedia> smlist = new ArrayList<>();
            smlist.add(sm1);


            List<SocialMedia> smlist2 = new ArrayList<>();
            smlist2.add(sm2);
            smlist2.add(sm3);



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
            ad1.setAddressType("Primary");

            Address ad2 = new Address();
            ad2.setAddressLine1("8823 chestnut");
            ad2.setState("CO");
            ad2.setZipcode("23458");
            ad2.setAddressType("Vacation");

            Address ad3 = new Address();
            ad3.setAddressLine1("8422 chestnut");
            ad3.setState("CO");
            ad3.setZipcode("23857");
            ad3.setAddressType("Primary");

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
            c1.setSocialMediaList(smlist);




            Customer c2 = new Customer();
            c2.setName("sam");
            c2.setGender("M");
            c2.setCreditScore(cs2);
            c2.setAddressList(addList2);
            c2.setContactList(conList2);
            c2.setSocialMediaList(smlist2);

            //Time
            LocalDateTime localDateTime = LocalDateTime.now();
            ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));

           // log.info("loading data "+ ER.save(eve1));
            //log.info("loading data "+ ER.save(eve2));
            eve1=ER.save(eve1);
            eve2= ER.save(eve2);
            //Create customer event
            CustomerEvent ce= new CustomerEvent();
            ce.setEventId(eve1.getId());
            ce.setEventType(eve1.getEventType());
            ce.setDescription(eve1.getDescription());
            ce.setCustomer(c1);
            //ce.setEventTime(zonedDateTime);
            ce.setStatus("Scheduled");

            CustomerEvent ce2= new CustomerEvent();
            ce2.setEventId(eve2.getId());
            ce2.setEventType(eve1.getEventType());
            ce2.setDescription(eve1.getDescription());
            ce2.setCustomer(c2);
            //ce2.setEventTime(zonedDateTime);
            ce2.setStatus("Scheduled");



            List<CustomerEvent> ceList= new ArrayList<>();
            ceList.add(ce);

            List<CustomerEvent> ceList2= new ArrayList<>();
           ceList2.add(ce2);



            //eve1.setEventSideEventList(ceList);
            c1.setCustomerSideEventList(ceList);

            //eve2.setEventSideEventList(ceList2);
            c2.setCustomerSideEventList(ceList2);



            log.info("loading data "+ repository.save( c1));
            //log.info("loading data "+ repository.save (c2));
            Customer temp1 =  repository.save (c2);

            List<CustomerEvent> tempList= temp1.getCustomerSideEventList();
            for(CustomerEvent customerEvent: tempList){
                log.info("check status "+ customerEvent.getStatus());
                customerEvent.setStatus("Cancelled");
            }

            repository.save(temp1);
            //repository.findCustomerList("Primary","Primary","Primary");
            List<CustomerDto> ct = cqr.getCustomerContactList();
            for (CustomerDto c : ct) {
                log.info("\nCustomer:\n\t" + c.toString());
            }
        };
    }

}
