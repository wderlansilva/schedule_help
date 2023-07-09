package com.schedulehelp.schedule.services.impl;

import com.schedulehelp.schedule.models.Address;
import com.schedulehelp.schedule.repositories.AddressRepository;
import com.schedulehelp.schedule.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void createAddress(List<Address> address) {
        this.addressRepository.save(address.get(0));
    }
}
