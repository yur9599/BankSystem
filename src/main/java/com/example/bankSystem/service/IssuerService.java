package com.example.bankSystem.service;

import com.example.bankSystem.dto.IssuerDTO;
import com.example.bankSystem.entities.Issuer;
import com.example.bankSystem.repository.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.bankSystem.mappers.IssuerMapper.*;

@Service
public class IssuerService {

    @Autowired
    private IssuerRepository issuerRepository;

    public Optional<IssuerDTO> getIssuerById(Long id){
        Issuer issuer = this.issuerRepository.findById(id).get();
        return Optional.of(toIssuerDTO(issuer));
    }

    public Optional<IssuerDTO> createIssuer(IssuerDTO issuerDTO){
        Issuer issuerToSave = toIssuer(issuerDTO);
        Issuer savedIssuer = this.issuerRepository.save(issuerToSave);
        return Optional.of(toIssuerDTO(savedIssuer));
    }

    public void deleteIssuer(Long id){
        this.issuerRepository.delete(issuerRepository.findById(id).get());
    }

    public Optional<IssuerDTO> updateIssuer(Long id,IssuerDTO issuerDTO){
        Issuer issuer = issuerRepository.findById(id).get();
        issuer.setBankName(issuerDTO.getBankName());
        issuer.setBankType(issuerDTO.getBankType());
        this.issuerRepository.save(issuer);
        return Optional.of(issuerDTO);
    }

}
