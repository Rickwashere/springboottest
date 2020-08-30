package com.example.demo.repository;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //@Query(value = "SELECT ct.ID as id, CUSTOMER_NAME as customerName,GENDER as gender, cs.CREDIT_SCORE as creditScore, ad.ADDRESS_LINE_1 as addressLine1,em.EMAIL_ADDRESS as emailAddress, phone.PHONE as phone FROM CUSTOMER_TABLE as ct INNER JOIN CREDIT_SCORE as cs ON ct.CREDITSCORE_ID = cs.ID INNER JOIN ADDRESS  as ad ON ct.ID = ad.CUSTOMER_ID INNER JOIN CONTACT as con ON ct.id = con.CUSTOMER_ID INNER JOIN EMAIL as em ON em.CONTACT_ID =con.ID INNER JOIN PHONE_NUMBERS as phone ON phone.CONTACT_ID = con.id WHERE ad.ADDRESS_TYPE = :addressType AND em.PREFERENCE = :emPref AND phone.PREFERENCES = :phonePref", nativeQuery = true)
    //List<CustomerDto> findCustomerList(@Param("addressType") String addressType, @Param("emPref") String emPref, @Param("phonePref") String phonePref);

}
