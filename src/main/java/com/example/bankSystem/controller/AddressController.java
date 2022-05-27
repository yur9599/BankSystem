package com.example.bankSystem.controller;

import com.example.bankSystem.dto.AddressDTO;
import com.example.bankSystem.responses.addressResponses.AddressCreationResponse;
import com.example.bankSystem.responses.addressResponses.AddressUpdateResponse;
import com.example.bankSystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody AddressDTO addressDTO){
        Assert.notNull(addressDTO,"Address is null ");
        Optional<AddressDTO> address = addressService.createAddress(addressDTO);
        if (address.isEmpty()){
            return new AddressCreationResponse(addressDTO).onFailure();
        }
        return new AddressCreationResponse(address.get()).onSuccess();
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id")Long id){
        addressService.deleteAddress(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id")Long id,@RequestBody AddressDTO addressDTO){
        Assert.notNull(addressDTO,"Address is null ");
        Optional<AddressDTO> address = addressService.updateAddress(id,addressDTO);
        if (address.isEmpty()){
            return new AddressUpdateResponse(addressDTO).onFailure();
        }
        return new AddressUpdateResponse(address.get()).onSuccess();
    }

}
