package com.example.bankSystem.dto;

import com.example.bankSystem.enums.BankType;

public class IssuerDTO {

    private String bankName;
    private BankType bankType;

    public IssuerDTO() {
    }

    public IssuerDTO(String bankName, BankType bankType) {
        this.bankName = bankName;
        this.bankType = bankType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }

}
