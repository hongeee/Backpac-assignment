package com.hongeee.backpac.user.service;

import com.hongeee.backpac.user.dto.UserDto;
import com.hongeee.backpac.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User createUserAccount(User user);

    User getUserAccount(String email);

    Page<User> getUserAccounts(Pageable pageable, String username, String email);
}
