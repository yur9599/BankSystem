package com.example.bankSystem.mappers;

import com.example.bankSystem.dto.IssuerDTO;
import com.example.bankSystem.entities.Issuer;
import org.springframework.stereotype.Component;

@Component
public class IssuerMapper {

    public static IssuerDTO toIssuerDTO(Issuer issuer){
        return new IssuerDTO(issuer.getBankName(),issuer.getBankType());
    }

    public static Issuer toIssuer(IssuerDTO issuerDTO){
        return new Issuer(issuerDTO.getBankName(),issuerDTO.getBankType());
    }

}
