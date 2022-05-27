package com.example.bankSystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "country",nullable = false,length = 40)
    private String country;
    @Column(name = "city",nullable = false,length = 40)
    private String city;
    @Column(name = "street",nullable = false,length = 40)
    private String street;
    @Column(name = "building",nullable = false,length = 35)
    private String building;
    @Column(name = "apartment",nullable = false,length = 10)
    private String apartment;

    @OneToMany(mappedBy = "address")
    private final Set<CardHolder> cardHolders = new HashSet<>();

    public Address() {
    }

    public Address(String country, String city, String street, String building, String apartment) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }

}
