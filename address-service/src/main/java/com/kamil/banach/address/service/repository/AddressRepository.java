package com.kamil.banach.address.service.repository;

import com.kamil.banach.address.service.entity.Address;
import com.kamil.banach.address.service.entity.EAddressContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByAddressId(Long addressId);

    List<Address> findAllByContextIdAndAddressContext(Long userId, EAddressContext userContext);
}
