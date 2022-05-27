package com.example.bankSystem.responses.cardHolderResponses;

import com.example.bankSystem.dto.CardHolderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CardHolderUpdateResponse {

    private CardHolderDTO cardHolderDTO;

    public CardHolderUpdateResponse(CardHolderDTO cardHolderDTO){
        this.cardHolderDTO = cardHolderDTO;
    }

    public ResponseEntity<?> onFailure(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The cardHolder isn`t exist ");
    }

    public ResponseEntity<CardHolderDTO> onSuccess(){
        return ResponseEntity.ok().body(cardHolderDTO);
    }

}
