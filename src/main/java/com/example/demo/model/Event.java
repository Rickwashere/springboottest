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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Event")
@JsonIgnoreProperties({ "customers"})
public class Event {
    private @Id
    @GeneratedValue
    Long id;

    @Column(name="Event_Type", nullable=false)
    private String eventType;

    @Column(name="Event_Description", nullable=false)
    private String description;

    @OneToMany(mappedBy = "event",
            cascade = CascadeType.ALL)
    private List<CustomerEvent> eventSideEventList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CustomerEvent> getEventSideEventList() {
        return eventSideEventList;
    }

    public void setEventSideEventList(List<CustomerEvent> eventSideEventList) {
        this.eventSideEventList = eventSideEventList;
        for(CustomerEvent ce: eventSideEventList){
            ce.setEvent(this);
        }
    }

    public Event() {
    }

}
