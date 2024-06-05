package com.sparta.newspeed.repository;

import com.sparta.newspeed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //유저네임이 있는 확인
    Boolean existsByUsername(String username);
}
