package com.kamil.banach.address.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String street;
    private String zipCode;
    private String city;
    private String country;
    private String state;
    private Long contextId;

    @Enumerated(EnumType.STRING)
    private EAddressContext addressContext;
}
