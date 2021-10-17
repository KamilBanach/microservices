package com.kamilbanach.department.service.service;

import com.kamilbanach.department.service.entity.Department;
import com.kamilbanach.department.service.repository.DepartmentRepository;
import com.kamilbanach.department.service.vo.Address;
import com.kamilbanach.department.service.vo.DepartmentWithAddressVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of Department Service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of Department Service");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public DepartmentWithAddressVO findDepartmentWithAddressById(Long departmentId) {
        DepartmentWithAddressVO departmentWithAddressVO = new DepartmentWithAddressVO();
        Department department = departmentRepository.findByDepartmentId(departmentId);
        Address address = restTemplate.getForObject("http://ADDRESS-SERVICE/address/" + department.getAddressId(), Address.class);
        departmentWithAddressVO.setDepartment(department);
        departmentWithAddressVO.setAddress(address);
        return departmentWithAddressVO;
    }
}
