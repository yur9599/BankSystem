package com.example.bankSystem.responses.cardHolderResponses;

import com.example.bankSystem.dto.AddressDTO;
import com.example.bankSystem.dto.CardHolderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CardHolderCreationResponse {

    private CardHolderDTO cardHolderDTO;

    public CardHolderCreationResponse(CardHolderDTO cardHolderDTO){
        this.cardHolderDTO = cardHolderDTO;
    }

    public ResponseEntity<?> onFailure(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The cardHolder is already exist ");
    }

    public ResponseEntity<CardHolderDTO> onSuccess(){
        return ResponseEntity.ok().body(cardHolderDTO);
    }

}
