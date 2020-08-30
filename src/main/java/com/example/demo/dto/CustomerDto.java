package com.example.demo.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {
   private Long id;
    private String customerName;
    private String gender;
    private Double creditScore;
    public String addressLine1;
    private String emailAddress;
    private String phone;

    public CustomerDto(Long id, String customerName, String gender, Double creditScore, String addressLine1, String emailAddress, String phone) {
        this.id = id;
        this.customerName = customerName;
        this.gender = gender;
        this.creditScore = creditScore;
        this.addressLine1 = addressLine1;
        this.emailAddress = emailAddress;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", gender='" + gender + '\'' +
                ", creditScore=" + creditScore +
                ", addressLine1='" + addressLine1 + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
