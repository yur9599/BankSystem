package com.example.bankSystem.mappers;

import com.example.bankSystem.dto.AddressDTO;
import com.example.bankSystem.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public static AddressDTO toAddressDTO(Address address){
        return new AddressDTO(address.getCountry(), address.getCity(), address.getStreet(),
                address.getBuilding(), address.getApartment());
    }

    public static Address toAddress(AddressDTO addressDTO){
        return new Address(addressDTO.getCountry(), addressDTO.getCity(), addressDTO.getStreet(),
                addressDTO.getBuilding(), addressDTO.getApartment());
    }

}
