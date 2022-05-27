package com.example.bankSystem.service;

import com.example.bankSystem.dto.AddressDTO;
import com.example.bankSystem.dto.CardHolderDTO;
import com.example.bankSystem.entities.Address;
import com.example.bankSystem.entities.CardHolder;
import com.example.bankSystem.repository.AddressRepository;
import com.example.bankSystem.repository.CardHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.bankSystem.mappers.AddressMapper.*;
import static com.example.bankSystem.mappers.CardHolderMapper.*;

@Service
public class CardHolderService {

    @Autowired
    private CardHolderRepository cardHolderRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Optional<CardHolderDTO> createCardHolder(CardHolderDTO cardHolderDTO){
        AddressDTO addressDTO = cardHolderDTO.getAddressDTO();
        Address chAddress = this.addressRepository.save(toAddress(addressDTO));
        CardHolder cardHolderToSave = toCardHolder(cardHolderDTO);
        cardHolderToSave.setAddress(chAddress);
        CardHolder cardHolder = cardHolderRepository.save(cardHolderToSave);
        return Optional.of(toCardHolderDTO(cardHolder));
    }

    public Optional<CardHolderDTO> updateCardHolder(Long id,CardHolderDTO cardHolderDTO){
        CardHolder cardHolder = cardHolderRepository.findById(id).get();
        Address chAddress = this.addressRepository.save(toAddress(cardHolderDTO.getAddressDTO()));
        cardHolder.setAddress(chAddress);
        cardHolder.setName(cardHolder.getName());
        cardHolder.setSureName(cardHolderDTO.getSureName());
        this.cardHolderRepository.save(cardHolder);
        return Optional.of(cardHolderDTO);
    }

    public void deleteCardHolder(Long id){
        this.cardHolderRepository.delete(cardHolderRepository.findById(id).get());
    }

}
