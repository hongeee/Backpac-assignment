package com.hongeee.backpac.user.service;

import com.hongeee.backpac.user.dto.UserDto;
import com.hongeee.backpac.user.entity.User;

public interface UserService {

    User createUserAccount(UserDto userDto);
}