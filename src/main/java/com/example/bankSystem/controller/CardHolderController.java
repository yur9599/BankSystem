package com.example.bankSystem.controller;

import com.example.bankSystem.dto.CardHolderDTO;
import com.example.bankSystem.responses.cardHolderResponses.CardHolderCreationResponse;
import com.example.bankSystem.responses.cardHolderResponses.CardHolderUpdateResponse;
import com.example.bankSystem.service.CardHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/card_holder")
public class CardHolderController {

    @Autowired
    private CardHolderService cardHolderService;

    @PostMapping
    public ResponseEntity<?> createCardHolder(@RequestBody CardHolderDTO cardHolderDTO){
        Assert.notNull(cardHolderDTO,"CardHolder is null ");
        Assert.notNull(cardHolderDTO.getAddressDTO(),"Address is null ");
        Optional<CardHolderDTO> cardHolder = cardHolderService.createCardHolder(cardHolderDTO);
        if (cardHolder.isEmpty()){
            return new CardHolderCreationResponse(cardHolderDTO).onFailure();
        }
        return new CardHolderCreationResponse(cardHolder.get()).onSuccess();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCardHolder(@PathVariable("id")Long id,@RequestBody CardHolderDTO cardHolderDTO){
        Assert.notNull(cardHolderDTO,"CardHolder is null ");
        Assert.notNull(cardHolderDTO.getAddressDTO(),"Address is null ");
        Optional<CardHolderDTO> cardHolder = cardHolderService.updateCardHolder(id,cardHolderDTO);
        if (cardHolder.isEmpty()){
            return new CardHolderUpdateResponse(cardHolderDTO).onFailure();
        }
        return new CardHolderUpdateResponse(cardHolder.get()).onSuccess();
    }

    @DeleteMapping("/{id}")
    public void deleteCardHolder(@PathVariable("id")Long id){
        try {
            cardHolderService.deleteCardHolder(id);
        }
        catch (NoSuchElementException e){
            System.out.println("oops");
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> findCardHolderById(@PathVariable("id")Long id){
//
//    }

}
