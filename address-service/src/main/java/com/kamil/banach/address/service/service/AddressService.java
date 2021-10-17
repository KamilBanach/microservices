package com.kamil.banach.address.service.service;

import com.kamil.banach.address.service.entity.Address;
import com.kamil.banach.address.service.entity.EAddressContext;
import com.kamil.banach.address.service.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        log.info("Inside saveAddress of AddressService");
        return addressRepository.save(address);
    }

    public Address findByAddressId(Long addressId) {
        log.info("Inside findByAddressId of AddressService");
        return addressRepository.findByAddressId(addressId);
    }

    public List<Address> saveAddressList(List<Address> addressList) {
        log.info("Inside saveAddressList of AddressService");
        return addressRepository.saveAll(addressList);
    }

    public List<Address> findByUserId(Long userId) {
        log.info("Inside findByUserId of AddressService");
        return addressRepository.findAllByContextIdAndAddressContext(userId, EAddressContext.USER);
    }
}
