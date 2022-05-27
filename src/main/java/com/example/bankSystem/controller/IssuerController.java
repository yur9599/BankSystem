package com.example.bankSystem.controller;

import com.example.bankSystem.dto.IssuerDTO;
import com.example.bankSystem.responses.issuerResponses.IssuerCreateResponse;
import com.example.bankSystem.responses.issuerResponses.IssuerFindResponse;
import com.example.bankSystem.responses.issuerResponses.IssuerUpdateResponse;
import com.example.bankSystem.service.IssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/issuer")
public class IssuerController {

    @Autowired
    private IssuerService issuerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getIssuerById(@PathVariable("id") Long id){
        Optional<IssuerDTO> issuer = issuerService.getIssuerById(id);
        if (issuer.isEmpty()){
            return new IssuerFindResponse(issuer.get()).onFailure();
        }
        return new IssuerFindResponse(issuer.get()).onSuccess();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIssuer(@PathVariable("id")Long id,@RequestBody IssuerDTO issuerDTO){
        Assert.notNull(issuerDTO,"Issuer is null ");
        Optional<IssuerDTO> issuer = issuerService.updateIssuer(id,issuerDTO);
        if (issuer.isEmpty()){
            return new IssuerUpdateResponse(issuerDTO).onFailure();
        }
        return new IssuerUpdateResponse(issuer.get()).onSuccess();
    }

    @DeleteMapping("/{id}")
    public void deleteIssuerById(@PathVariable("id")Long id){
        issuerService.deleteIssuer(id);
    }

    @PostMapping
    public ResponseEntity<?> saveIssuer(@RequestBody IssuerDTO issuerDTO){
        Assert.notNull(issuerDTO,"Issuer is null ");
        Optional<IssuerDTO> issuer = issuerService.createIssuer(issuerDTO);
        if (issuer.isEmpty()){
            return new IssuerCreateResponse(issuerDTO).onFailure();
        }
        return new IssuerCreateResponse(issuer.get()).onSuccess();
    }

}
