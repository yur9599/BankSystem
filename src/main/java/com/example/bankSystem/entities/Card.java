package com.example.bankSystem.entities;

import com.example.bankSystem.enums.CardStatus;
import com.example.bankSystem.enums.CardType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_type",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardType cardType;
    @Column(name = "card_number",nullable = false,length = 16,unique = true)
    private String cardNumber;
    @Column(name = "expiration_date",nullable = false)
    private LocalDate expirationDate;
    @Column(name = "cvc_code",nullable = false,length = 3)
    private String cVCCode;
    @Column(name = "card_status",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus status;

    @Column(name = "pin",length = 4)
    private String pin;
    @JoinColumn(name = "account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Card() {
    }

    public Card(CardType cardType, LocalDate expirationDate,  Account account, String cardNumber, String cVCCode) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cVCCode = cVCCode;
        this.status = CardStatus.CREATED;
        this.account = account;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVCCode() {
        return cVCCode;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    private static String cardNumberGenerator() {
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int c = random.nextInt(10);
        int d = random.nextInt(10);
        int e = random.nextInt(10);
        int f = random.nextInt(10);
        int g = random.nextInt(10);
        int h = random.nextInt(10);
        int i = random.nextInt(10);
        int j = random.nextInt(10);
        int k = random.nextInt(10);
        int l = random.nextInt(10);
        int m = random.nextInt(10);
        int n = random.nextInt(10);
        int o = random.nextInt(10);
        int p = random.nextInt(10);
        return ""+a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p;
    }

    private static String cvcGenerator(){
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int c = random.nextInt(10);
        return ""+a+b+c;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardType=" + cardType +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", cVCCode='" + cVCCode + '\'' +
                ", status=" + status +
                ", account=" + account +
                '}';
    }

}
