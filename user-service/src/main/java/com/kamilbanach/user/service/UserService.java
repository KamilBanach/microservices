package com.kamilbanach.user.service;

import com.kamilbanach.user.VO.Department;
import com.kamilbanach.user.VO.ResponseTemplateVO;
import com.kamilbanach.user.entity.User;
import com.kamilbanach.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        User user = userRepository.findByUserId(userId);
        return ResponseTemplateVO.builder()
                .user(user)
                .department(restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class))
                .build();
    }
}
