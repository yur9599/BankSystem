package com.example.bankSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO {

    private long balance;
    @JsonProperty("issuer")
    private IssuerDTO issuer;
    @JsonProperty("cardHolder")
    private CardHolderDTO cardHolder;

    public AccountDTO() {
    }

    public AccountDTO(long balance, IssuerDTO issuer, CardHolderDTO cardHolder) {
        this.balance = balance;
        this.issuer = issuer;
        this.cardHolder = cardHolder;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public IssuerDTO getIssuer() {
        return issuer;
    }

    public void setIssuer(IssuerDTO issuer) {
        this.issuer = issuer;
    }

    public CardHolderDTO getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolderDTO cardHolder) {
        this.cardHolder = cardHolder;
    }
}