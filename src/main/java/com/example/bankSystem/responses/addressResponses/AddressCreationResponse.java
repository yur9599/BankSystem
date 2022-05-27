package com.example.bankSystem.responses.addressResponses;

import com.example.bankSystem.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddressCreationResponse {

    private AddressDTO addressDTO;

    public AddressCreationResponse(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public ResponseEntity<?> onFailure(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The address is already exist ");
    }

    public ResponseEntity<AddressDTO> onSuccess(){
        return ResponseEntity.ok().body(addressDTO);
    }

}
