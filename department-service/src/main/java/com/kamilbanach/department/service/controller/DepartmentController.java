package com.kamilbanach.department.service.controller;

import com.kamilbanach.department.service.entity.Department;
import com.kamilbanach.department.service.service.DepartmentService;
import com.kamilbanach.department.service.vo.DepartmentWithAddressVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/address/{id}")
    public DepartmentWithAddressVO findDepartmentWithAddressById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentWithAddressById method of DepartmentController");
        return departmentService.findDepartmentWithAddressById(departmentId);
    }
}
