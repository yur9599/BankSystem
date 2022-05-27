package com.example.bankSystem.responses.accountResponses;

import com.example.bankSystem.dto.AccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AccountCreationResponse {

    private AccountDTO accountDTO;

    public AccountCreationResponse(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    public ResponseEntity<?> onFailure(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The account is already exist ");
    }

    public ResponseEntity<AccountDTO> onSuccess(){
        return ResponseEntity.ok().body(accountDTO);
    }

}
