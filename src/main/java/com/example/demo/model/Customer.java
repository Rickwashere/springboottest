package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Customer_table")
//@JsonIgnoreProperties({  "creditScore"})

public class Customer extends Auditable<String> {

    private @Id @GeneratedValue Long id;
    @Column(name="Customer_Name", nullable=false, length=100)
    private String name;
    private String gender;
    //credit score
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creditscore_id", referencedColumnName = "id")
    private CreditScore creditScore;
    // Address
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )

    private List<Address> addressList = new ArrayList<>();

    //Contact
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Contact> contactList =  new ArrayList<>();

    public CreditScore getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
    }


    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
        for (Address add : addressList) {
            add.setCustomer(this);
        }
    }


    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
        for (Contact c : contactList) {
            c.setCustomer(this);
        }
    }

    public Customer() {
    }
/*
    public Customer(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getGender(), customer.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGender());
    }


}
