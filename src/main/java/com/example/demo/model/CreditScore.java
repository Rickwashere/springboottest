package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Credit_Score")
@JsonIgnoreProperties({ "customer"})
public class CreditScore {
    private @Id @GeneratedValue Long id;
    @Column(name="Credit_Score", nullable=false)
    private Double CreditScore;

    @Column(name="Provider_Name", nullable=false, length=100)
    private String providerName;

    @OneToOne(mappedBy = "creditScore")
    Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCreditScore() {
        return CreditScore;
    }

    public void setCreditScore(Double creditScore) {
        CreditScore = creditScore;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public CreditScore() {
    }


    @Override
    public String toString() {
        return "CreditScore{" +
                "id=" + id +
                ", CreditScore=" + CreditScore +
                ", providerName='" + providerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditScore)) return false;
        CreditScore that = (CreditScore) o;
        return getId().equals(that.getId()) &&
                getCreditScore().equals(that.getCreditScore()) &&
                getProviderName().equals(that.getProviderName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreditScore(), getProviderName());
    }
}
