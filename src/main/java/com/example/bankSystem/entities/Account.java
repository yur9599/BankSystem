package com.example.bankSystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "iban",nullable = false,length = 40,unique = true)
    private String iBAN;
    @Column(name = "balance")
    private long balance;
    @JoinColumn(name = "issuer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Issuer issuer;

    @JoinColumn(name = "crd_hldr_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CardHolder cardHolder;

    @OneToMany(mappedBy = "account")
    private final Set<Card> cards = new HashSet<>();

    public Account() {
    }

    public Account(long balance, Issuer issuer, CardHolder cardHolder) {
        this.balance = balance;
        this.issuer = issuer;
        this.cardHolder = cardHolder;
        this.iBAN=iBANGenerator();
    }

    public String getIBAN() {
        return iBAN;
    }
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public Issuer getIssuer() {
        return issuer;
    }
    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }
    public CardHolder getCardHolder() {
        return cardHolder;
    }
    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    private static String  iBANGenerator(){
        Random random = new Random();
        char f = (char) (random.nextInt(25)+65);
        char s = (char) (random.nextInt(25)+65);
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        char l = (char) (random.nextInt(25)+65);
        char m = (char) (random.nextInt(25)+65);
        char n = (char) (random.nextInt(25)+65);
        char o = (char) (random.nextInt(25)+65);
        char p = (char) (random.nextInt(25)+65);
        char q = (char) (random.nextInt(25)+65);
        char r = (char) (random.nextInt(25)+65);
        char t = (char) (random.nextInt(25)+65);
        int c = random.nextInt(10);
        int d = random.nextInt(10);
        int e = random.nextInt(10);
        int g = random.nextInt(10);
        int h = random.nextInt(10);
        int i = random.nextInt(10);
        int j = random.nextInt(10);
        int k = random.nextInt(10);
        return ""+f+s+a+b+(char)((c%2==0)? c+'0':l)+(char)((d%2==0)? d+'0':m)+(char)((e%2==0)? e+'0':n)+
                (char)((g%2==0)? g+'0':o)+(char)((h%2==0)? h+'0':p)+(char)((i%2==0)? i+'0':q)+
                (char)((j%2==0)? j+'0':r)+(char)((k%2==0)? k+'0':t);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iBAN='" + iBAN + '\'' +
                ", balance=" + balance +
                ", issuer=" + issuer +
                ", cardHolder=" + cardHolder +
                '}';
    }

}
