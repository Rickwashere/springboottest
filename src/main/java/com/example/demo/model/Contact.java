package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Contact")
@JsonIgnoreProperties({ "customer"})

public class Contact {
    private @Id
    @GeneratedValue
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    //Phone
    @OneToMany(
            mappedBy = "contact",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )

    private List<Telephone> phoneList = new ArrayList<>();

    //Email
    @OneToMany(
            mappedBy = "contact",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )

    private List<Email> emailList = new ArrayList<>();

    public Contact() {
    }

    public List<Telephone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Telephone> phoneList) {
        this.phoneList = phoneList;
        for (Telephone t: phoneList) {
            t.setContact(this);
        }
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
        for (Email e: emailList) {
            e.setContact(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getId().equals(contact.getId()) &&
                getCustomer().equals(contact.getCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer());
    }
}
