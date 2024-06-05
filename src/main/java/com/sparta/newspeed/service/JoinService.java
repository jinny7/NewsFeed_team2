package com.sparta.newspeed.service;

import com.sparta.newspeed.dto.JoinDto;
import com.sparta.newspeed.entity.User;
import com.sparta.newspeed.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void signup(JoinDto joinDto) {

        String username = joinDto.getUsername();
        String password = joinDto.getPassword();

        //유저이름이 존재하는 지확인
        Boolean isExist = userRepository.existsByUsername(username);

        if(isExist){

            return;
        }
        //존재하지 않으면 회원 가입 처리
        User user = new User();

        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole("ROLE_ADMIN");

        userRepository.save(user);
    }
}
