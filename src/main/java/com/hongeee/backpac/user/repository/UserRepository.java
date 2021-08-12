package com.hongeee.backpac.user.repository;

import com.hongeee.backpac.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Page<User> findAllByEmailAndUsername(Pageable pageable, String email, String username);

    Page<User> findAllByUsername(Pageable pageable, String username);

    Page<User> findAllByEmail(Pageable pageable, String email);
}
