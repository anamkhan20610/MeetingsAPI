package com.MeetingAPIs.MeetingAPIs.Models;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable

public class Address implements Serializable {
    private String h_number;
    private String street;
    private String city;

    public Address(String h_number, String street, String city) {
        this.h_number = h_number;
        this.street = street;
        this.city = city;
    }

    public Address() {
    }

    public String getH_number() {
        return h_number;
    }

    public void setH_number(String h_number) {
        this.h_number = h_number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "h_number='" + h_number + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
