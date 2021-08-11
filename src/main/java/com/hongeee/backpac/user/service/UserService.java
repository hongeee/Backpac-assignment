package com.hongeee.backpac.user.service;

import com.hongeee.backpac.user.dto.UserDto;
import com.hongeee.backpac.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User createUserAccount(UserDto userDto);

    User getUserAccount(String email);

    Page<User> getUserAccounts(Pageable pageable);
}
