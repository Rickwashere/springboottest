package com.example.demo.repository;


import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerQueryRepository {
    @PersistenceContext
    private EntityManager manager;
    public List<CustomerDto> getCustomerContactList() {
        Query q = manager.createNativeQuery("SELECT ct.ID as id, CUSTOMER_NAME as customerName,GENDER as gender, cs.CREDIT_SCORE as creditScore, ad.ADDRESS_LINE_1 as addressLine1,em.EMAIL_ADDRESS as emailAddress, phone.PHONE as phone FROM CUSTOMER_TABLE as ct INNER JOIN CREDIT_SCORE as cs ON ct.CREDITSCORE_ID = cs.ID INNER JOIN ADDRESS  as ad ON ct.ID = ad.CUSTOMER_ID INNER JOIN CONTACT as con ON ct.id = con.CUSTOMER_ID INNER JOIN EMAIL as em ON em.CONTACT_ID =con.ID INNER JOIN PHONE_NUMBERS as phone ON phone.CONTACT_ID = con.id WHERE ad.ADDRESS_TYPE = 'Primary' AND em.PREFERENCE = 'Primary' AND phone.PREFERENCES = 'Primary'",
                "CustomerDtoMapper");

        //q.setParameter("addressType","Primary").setParameter("emPref","Primary").setParameter("phonePref","Primary")
        List<CustomerDto> ct =  q.getResultList();


        return  ct;
    }
}
