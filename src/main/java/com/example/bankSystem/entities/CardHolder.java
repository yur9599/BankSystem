package com.example.bankSystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "card_holder")
public class CardHolder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 20)
    private String name;
    @Column(name = "sure_name",length = 25)
    private String sureName;

    @OneToMany(mappedBy = "cardHolder")
    private final Set<Account> accounts = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public CardHolder() {
    }

    public CardHolder(String name, String sureName, Address address) {
        this.name = name;
        this.sureName = sureName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CardHolder{" +
                "name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                ", address=" + address +
                '}';
    }

}
