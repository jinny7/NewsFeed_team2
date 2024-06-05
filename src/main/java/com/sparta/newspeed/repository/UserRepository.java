package com.sparta.newspeed.repository;

import com.sparta.newspeed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //유저네임이 있는 확인
    Boolean existsByUsername(String username);

    //username을 받아서 DB에서 회원 조회하는 메서드
    User findByUsername(String username);
}
