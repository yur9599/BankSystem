package com.example.bankSystem.service;

import com.example.bankSystem.dto.AddressDTO;
import com.example.bankSystem.entities.Address;
import com.example.bankSystem.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.bankSystem.mappers.AddressMapper.toAddress;
import static com.example.bankSystem.mappers.AddressMapper.toAddressDTO;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Optional<AddressDTO> createAddress(AddressDTO addressDTO){
        Address addressToSave = toAddress(addressDTO);
        Address savedAddress = this.addressRepository.save(addressToSave);
        return Optional.of(toAddressDTO(savedAddress));
    }

    public void deleteAddress(Long id){
        Address address = addressRepository.findById(id).get();
        this.addressRepository.delete(address);
    }

    public Optional<AddressDTO> updateAddress(Long id,AddressDTO addressDTO){
        Address address = addressRepository.findById(id).get();
        address.setApartment(addressDTO.getApartment());
        address.setBuilding(addressDTO.getBuilding());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setStreet(addressDTO.getStreet());
        this.addressRepository.save(address);
        return Optional.of(addressDTO);
    }

}
