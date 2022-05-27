package com.example.bankSystem.mappers;

import com.example.bankSystem.dto.CardHolderDTO;
import com.example.bankSystem.entities.CardHolder;
import org.springframework.stereotype.Component;

import static com.example.bankSystem.mappers.AddressMapper.*;

@Component
public class CardHolderMapper {

    public static CardHolderDTO toCardHolderDTO(CardHolder cardHolder){
        return new CardHolderDTO(cardHolder.getName(), cardHolder.getSureName(),
                toAddressDTO(cardHolder.getAddress()));
    }

    public static CardHolder toCardHolder(CardHolderDTO cardHolderDTO){
        return new CardHolder(cardHolderDTO.getName(), cardHolderDTO.getSureName(),
                toAddress(cardHolderDTO.getAddressDTO()));
    }

}
