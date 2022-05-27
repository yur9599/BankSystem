package com.example.bankSystem.dto;

import com.example.bankSystem.enums.CardStatus;
import com.example.bankSystem.enums.CardType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CardDTO {

    private CardType cardType;
    private LocalDate expirationDate;
    @JsonProperty("account")
    private AccountDTO account;
    private String cVCCode;
    private String cardNumber;

    private CardStatus status;

    public CardDTO() {
    }

    public CardDTO(CardType cardType, LocalDate expirationDate, AccountDTO account, String cVCCode, String cardNumber,
                   CardStatus status) {
        this.cardType = cardType;
        this.expirationDate = expirationDate;
        this.account = account;
        this.cVCCode = cVCCode;
        this.cardNumber = cardNumber;
        this.status = status;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public String getCVCCode() {
        return cVCCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CardStatus getStatus() {
        return status;
    }

}
