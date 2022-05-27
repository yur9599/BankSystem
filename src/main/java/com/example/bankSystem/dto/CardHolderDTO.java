package com.example.bankSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardHolderDTO {

    private String name;
    private String sureName;
    @JsonProperty("address")
    private AddressDTO address;

    public CardHolderDTO() {
    }

    public CardHolderDTO(String name, String sureName, AddressDTO address) {
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

    public AddressDTO getAddressDTO() {
        return address;
    }

    public void setAddressDTO(AddressDTO address) {
        this.address = address;
    }

}
