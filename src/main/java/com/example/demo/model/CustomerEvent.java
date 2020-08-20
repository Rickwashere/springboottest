package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Customer_Event")
@JsonIgnoreProperties({ "customer", "event"})

public class CustomerEvent {
    private @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

   /* @Column(name="Event_Date", nullable=false)
    //private ZonedDateTime eventTime;
    */


    @Column(name="Event_Status", nullable=false)
    private String status;

    public CustomerEvent() {

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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        Event newEvent= new Event();
        this.event = event;
        newEvent.setEventType(event.getEventType());
        newEvent.setDescription(event.getDescription());
    }
 /*
    public ZonedDateTime getEventTime() {
        return eventTime;
    }
*/
 /*
    public void setEventTime(ZonedDateTime eventTime) {
        this.eventTime = eventTime;
    }
*/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
