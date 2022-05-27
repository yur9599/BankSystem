package com.example.bankSystem.service;

import com.example.bankSystem.dto.AddressDTO;
import com.example.bankSystem.entities.Address;
import com.example.bankSystem.repository.AccountRepository;
import com.example.bankSystem.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.bankSystem.mappers.AddressMapper.*;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

}
