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

    /**
     * 입력된 정보를 이용하여 회원 가입한다.
     *
     * @param userDto 이메일, 이름, 별명, 비밀번호, 전화번호, 성별
     * @return 회원 가입 성공시 가입 정보
     */
    @PostMapping("/signup")
    public User signup(@RequestBody UserDto userDto) {
        User user = userService.getUserAccount(userDto.getEmail());

        if (user != null) {
            // already exist account
            return null;
        }

        return userService.createUserAccount(userDto.toEntity());
    }

    /**
     * 입력된 정보를 이용하여 로그인한다. (미구현)
     *
     * @param userDto
     * @return
     */
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

    /**
     * 로그인 계정을 로그아웃한다. (미구현)
     */
    @DeleteMapping("/logout")
    public void logout() {

    }

    /**
     * 회원 상세 정보를 조회한다.
     *
     * @param email 회원 이메일
     * @return 회원 상세 정보
     */
    @GetMapping("/users/{email}")
    public User getUserDetail(@PathVariable String email) {
        User user = userService.getUserAccount(email);

        return user;
    }

    /**
     * 페이지네이션, 이름, 이메일을 검색 조건으로 여러 회원 목록을 조회한다.
     *
     * @param pageable 페이지네이션 옵션
     * @param username 이름
     * @param email 이메일
     * @return 검색된 회원 목록
     */
    @GetMapping("/users")
    public ResponseEntity<Page<User>> getUsers(@PageableDefault Pageable pageable, @RequestParam(required = false) String username, @RequestParam(required = false) String email) {
        Page<User> users = userService.getUserAccounts(pageable, username, email);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
