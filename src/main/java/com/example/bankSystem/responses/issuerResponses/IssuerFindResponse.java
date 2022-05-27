package com.example.bankSystem.responses.issuerResponses;

import com.example.bankSystem.dto.IssuerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IssuerFindResponse {

    private IssuerDTO issuerDTO;

    public IssuerFindResponse(IssuerDTO issuerDTO) {
        this.issuerDTO = issuerDTO;
    }

    public ResponseEntity<?> onFailure(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There isn`t issuer with such id ");
    }

    public ResponseEntity<IssuerDTO> onSuccess(){
        return ResponseEntity.ok().body(issuerDTO);
    }

}
