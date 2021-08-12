package com.hongeee.backpac.user.service;

import com.hongeee.backpac.user.entity.User;
import com.hongeee.backpac.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User createUserAccount(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserAccount(String email) {
        Optional<User> user = userRepository.findById(email);

        return user.orElse(null);
    }

    @Override
    public Page<User> getUserAccounts(Pageable pageable, String username, String email) {
        int page = pageable.getPageNumber();
        pageable = PageRequest.of(page <= 0 ? 0 : page - 1, pageable.getPageSize());

        if (username != null && email != null) {
            return userRepository.findAllByEmailAndUsername(pageable, email, username);
        }

        if (username != null) {
            return userRepository.findAllByUsername(pageable, username);
        }

        if (email != null) {
            return userRepository.findAllByEmail(pageable, email);
        }

        return userRepository.findAll(pageable);
    }
}
