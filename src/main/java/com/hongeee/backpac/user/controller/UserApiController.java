package com.hongeee.backpac.user.controller;

import com.hongeee.backpac.user.dto.UserDto;
import com.hongeee.backpac.user.entity.User;
import com.hongeee.backpac.user.repository.UserRepository;
import com.hongeee.backpac.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody UserDto userDto) {
        User user = userService.getUserAccount(userDto.getEmail());

        if (user != null) {
            // already exist account
            return null;
        }

        return userService.createUserAccount(userDto);
    }

    @PostMapping("/signin")
    public User signin(@RequestBody UserDto userDto) {
        String email = userDto.getEmail();
        String password = userDto.getPassword();

        User user = userService.getUserAccount(email);

        if (user == null) {
            // incorrect user account
            return null;
        }

        if (password.equals(user.getPassword())) {
            return user;
        }

        // password not matches
        return null;
    }

    @DeleteMapping("/logout")
    public void logout() {

    }

    @GetMapping("/users/{email}")
    public User getUserDetail(@PathVariable String email) {
        return userService.getUserAccount(email);
    }

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getUsers(@PageableDefault Pageable pageable) {
        Page<User> users = userService.getUserAccounts(pageable);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
