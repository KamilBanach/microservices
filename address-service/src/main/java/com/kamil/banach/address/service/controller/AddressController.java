package com.kamil.banach.address.service.controller;

import com.kamil.banach.address.service.entity.Address;
import com.kamil.banach.address.service.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/")
    public Address saveAddress(@RequestBody Address address) {
        log.info("Inside saveAddress of AddressController");
        return addressService.saveAddress(address);
    }

    @PostMapping("/list/")
    public List<Address> saveAddressList(@RequestBody List<Address> addressList) {
        log.info("Inside saveAddress of AddressController");
        return addressService.saveAddressList(addressList);
    }

    @GetMapping("/{id}")
    public Address findByAddressId(@PathVariable("id") Long addressId) {
        log.info("Inside findByAddressId of AddressController");
        return addressService.findByAddressId(addressId);
    }
    @GetMapping("/byUser/{id}")
    public List<Address> findByUserId(@PathVariable("id") Long userId) {
        log.info("Inside findByUserId of AddressController");
        return addressService.findByUserId(userId);
    }
}
