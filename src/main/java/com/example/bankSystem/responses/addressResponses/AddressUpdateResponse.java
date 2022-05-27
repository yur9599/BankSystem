package com.example.bankSystem.responses.addressResponses;

import com.example.bankSystem.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddressUpdateResponse {

    private AddressDTO addressDTO;

    public AddressUpdateResponse(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public ResponseEntity<?> onFailure(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The address isn`t exist ");
    }

    public ResponseEntity<AddressDTO> onSuccess(){
        return ResponseEntity.ok().body(addressDTO);
    }

}
