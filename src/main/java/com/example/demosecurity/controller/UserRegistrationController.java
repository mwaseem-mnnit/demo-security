package com.example.demosecurity.controller;

import com.example.demosecurity.dto.UserDTO;
import com.example.demosecurity.service.UserDetailServiceH2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mohd.waseem on 28/06/20.
 */
@RestController
@RequestMapping("user")
public class UserRegistrationController {
    private final UserDetailServiceH2 userDetailService;

    public UserRegistrationController(UserDetailServiceH2 userDetailService) {
        this.userDetailService = userDetailService;
    }

    @PostMapping("register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) throws Exception {
        userDetailService.createUser(userDTO);
        return ResponseEntity.ok(userDTO);
    }
}
