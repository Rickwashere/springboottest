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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="SocialMedia")
@JsonIgnoreProperties({ "customers"})
public class SocialMedia {
    private @Id
    @GeneratedValue
    Long id;

    @Column(name="SocialMedia_Name", nullable=false)
    private String SocialMediaName;

    @ManyToMany(mappedBy = "socialMediaList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();


    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customer) {
        customers.add(customer);
        customer.getSocialMediaList().add(this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocialMediaName() {
        return SocialMediaName;
    }

    public void setSocialMediaName(String socialMediaName) {
        SocialMediaName = socialMediaName;
    }

    public SocialMedia() {
    }
}
