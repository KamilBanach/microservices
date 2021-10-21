package com.kamilbanach.user.service;

import com.kamilbanach.user.VO.Address;
import com.kamilbanach.user.VO.Department;
import com.kamilbanach.user.VO.ResponseTemplateVO;
import com.kamilbanach.user.entity.User;
import com.kamilbanach.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        log.info("Inside findUserById method of UserService");
        return userRepository.findByUserId(id);
    }

    public ResponseTemplateVO findUserWithDepartment(Long userId) {
        log.info("Inside findUserWithDepartment method of UserService");
        User user = userRepository.findByUserId(userId);
        return ResponseTemplateVO.builder()
                .user(user)
                .department(restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class))
                .build();
    }

    public ResponseTemplateVO findUserWithDepartmentAndAddress(Long userId) {
        log.info("Inside findUserWithDepartmentAndAddress method of UserService");
        User user = userRepository.findByUserId(userId);
        ResponseEntity<List<Address>> addressResponse = restTemplate.exchange(
                "http://ADDRESS-SERVICE/address/byUser/" + userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        return ResponseTemplateVO.builder()
                .user(user)
                .department(restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class))
                .addressList(addressResponse.getBody())
                .build();
    }
}
