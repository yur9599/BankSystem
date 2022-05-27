package com.example.bankSystem.mappers;

import com.example.bankSystem.dto.CardDTO;
import com.example.bankSystem.entities.Card;
import org.springframework.stereotype.Component;

import static com.example.bankSystem.mappers.AccountMapper.*;

@Component
public class CardMapper {

    public static CardDTO toCardDTO(Card card){
        return new CardDTO(card.getCardType(),card.getExpirationDate(),
                toAccountDTO(card.getAccount()), card.getCVCCode(), card.getCardNumber(),card.getStatus());
    }

    public static Card toCard(CardDTO cardDTO){
        return new Card(cardDTO.getCardType(),cardDTO.getExpirationDate(), toAccount(cardDTO.getAccount()),
                cardDTO.getCardNumber(), cardDTO.getCVCCode());
    }

}
