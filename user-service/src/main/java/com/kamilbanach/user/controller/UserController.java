package com.kamilbanach.user.controller;

import com.kamilbanach.user.VO.ResponseTemplateVO;
import com.kamilbanach.user.entity.User;
import com.kamilbanach.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/getWithDepartment/{id}")
    public ResponseTemplateVO findUserWithDepartment(@PathVariable("id") Long userId) {
        return userService.findUserWithDepartment(userId);
    }

    @GetMapping("/getWithDepartmentAndAddress/{id}")
    public ResponseTemplateVO findUserWithDepartmentAndAddress(@PathVariable("id") Long userId) {
        return userService.findUserWithDepartmentAndAddress(userId);
    }
}
