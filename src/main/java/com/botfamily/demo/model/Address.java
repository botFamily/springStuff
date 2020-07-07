package com.botfamily.demo.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String city;
    private String street;
    private String country;

    public Address(String city, String street, String country) {
        this.city = city;
        this.street = street;
        this.country = country;
    }

    public Address() {
    }
}
