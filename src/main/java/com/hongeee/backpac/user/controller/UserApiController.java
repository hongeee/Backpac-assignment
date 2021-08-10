package com.hongeee.backpac.user.controller;

import com.hongeee.backpac.user.dto.UserDto;
import com.hongeee.backpac.user.entity.User;
import com.hongeee.backpac.user.repository.UserRepository;
import com.hongeee.backpac.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody UserDto userDto) {
        return userService.createUserAccount(userDto);
    }
}
