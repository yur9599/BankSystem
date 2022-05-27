package com.example.bankSystem.mappers;

import com.example.bankSystem.dto.AccountDTO;
import com.example.bankSystem.entities.Account;
import org.springframework.stereotype.Component;

import static com.example.bankSystem.mappers.CardHolderMapper.*;
import static com.example.bankSystem.mappers.IssuerMapper.*;

@Component
public class AccountMapper {

    public static AccountDTO toAccountDTO(Account account){
        return new AccountDTO(account.getBalance(), toIssuerDTO(account.getIssuer()),
                toCardHolderDTO(account.getCardHolder()));
    }

    public static Account toAccount(AccountDTO accountDTO){
        return new Account(accountDTO.getBalance(), toIssuer(accountDTO.getIssuer()),
                toCardHolder(accountDTO.getCardHolder()));
    }

}
