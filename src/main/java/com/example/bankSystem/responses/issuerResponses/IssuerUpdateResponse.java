package com.example.bankSystem.responses.issuerResponses;

import com.example.bankSystem.dto.IssuerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IssuerUpdateResponse {

    private IssuerDTO issuerDTO;

    public IssuerUpdateResponse(IssuerDTO issuerDTO) {
        this.issuerDTO = issuerDTO;
    }

    public ResponseEntity<?> onFailure(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The issuer isn`t exist ");
    }

    public ResponseEntity<IssuerDTO> onSuccess(){
        return ResponseEntity.ok().body(issuerDTO);
    }

}
