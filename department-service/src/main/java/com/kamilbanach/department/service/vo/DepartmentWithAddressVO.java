package com.kamilbanach.department.service.vo;

import com.kamilbanach.department.service.entity.Department;
import lombok.Data;

@Data
public class DepartmentWithAddressVO {
    private Department department;
    private Address address;
}
