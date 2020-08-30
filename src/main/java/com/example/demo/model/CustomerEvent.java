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
import javax.persistence.Transient;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Customer_Event")
@JsonIgnoreProperties({ "customer","event"})

public class CustomerEvent {
    private @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    //@JsonManagedReference
    private Customer customer;

    private Long eventId;

/*
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name = "event_id")

    private Event event;

 */

   /* @Column(name="Event_Date", nullable=false)
    //private ZonedDateTime eventTime;
    */
   @Transient
   private String eventType;

    @Transient
    private String description;

    @Column(name="Event_Status", nullable=false)
    private String status;

    public CustomerEvent() {

    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long event_id) {
        this.eventId = event_id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    /*
       public Event getEvent() {
           return event;
       }

       public void setEvent(Event event) {
           this.event = event;
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
