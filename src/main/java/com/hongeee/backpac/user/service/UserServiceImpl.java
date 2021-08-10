package com.hongeee.backpac.user.service;

import com.hongeee.backpac.user.dto.UserDto;
import com.hongeee.backpac.user.entity.User;
import com.hongeee.backpac.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User createUserAccount(UserDto userDto) {
        return userRepository.save(userDto.toEntity());
    }
}
