package com.example.bankSystem.responses.issuerResponses;

import com.example.bankSystem.dto.IssuerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IssuerCreateResponse {

    private IssuerDTO issuerDTO;

    public IssuerCreateResponse(IssuerDTO issuerDTO) {
        this.issuerDTO = issuerDTO;
    }

    public ResponseEntity<?> onFailure(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The issuer is already exist ");
    }

    public ResponseEntity<IssuerDTO> onSuccess(){
        return ResponseEntity.ok().body(issuerDTO);
    }

}
