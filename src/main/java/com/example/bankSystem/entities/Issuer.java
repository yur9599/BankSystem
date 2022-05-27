package com.example.bankSystem.entities;

import com.example.bankSystem.enums.BankType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "issuer")
public class Issuer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bank_name",nullable = false,length = 40)
    private String bankName;
    @Column(name = "bank_type",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BankType bankType;

    @OneToMany(mappedBy = "issuer")
    private final Set<Account> accounts = new HashSet<>();

    public Issuer() {
    }

    public Issuer(String bankName, BankType bankType) {
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

    @Override
    public String toString() {
        return "Issuer{" +
                "bankName='" + bankName + '\'' +
                ", bankType=" + bankType +
                '}';
    }

}
