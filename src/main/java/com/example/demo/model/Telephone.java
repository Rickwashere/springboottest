package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Phone_Numbers")
@JsonIgnoreProperties({ "contact"})

public class Telephone {
    private @Id
    @GeneratedValue
    Long id;
    private String phone;
    private String phoneType;
    private String preferences;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    public Telephone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", preferences='" + preferences + '\'' +
                ", contact=" + contact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telephone)) return false;
        Telephone telephone = (Telephone) o;
        return getId().equals(telephone.getId()) &&
                getPhone().equals(telephone.getPhone()) &&
                getPhoneType().equals(telephone.getPhoneType()) &&
                Objects.equals(getPreferences(), telephone.getPreferences()) &&
                getContact().equals(telephone.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhone(), getPhoneType(), getPreferences(), getContact());
    }
}
