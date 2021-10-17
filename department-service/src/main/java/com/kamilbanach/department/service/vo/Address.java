package com.kamilbanach.department.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private Long addressId;
    private String street;
    private String zipCode;
    private String city;
    private String country;
    private String state;
}
