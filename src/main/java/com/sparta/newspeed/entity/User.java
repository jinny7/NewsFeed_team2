package com.sparta.newspeed.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    //사용자 ID
    @Column(unique = true, nullable = false)
    private String userLoginId; // J : 유저 클래스의 아이디가 조인콜롬에 사용되어야 하는데, 명칭이 불명확하여 사용자 아이디를 userLoginId로, 유저 클래스의 고유 아이디를 userId로 변경함

    //사용자 비밀번호
    @Length(min = 8, max = 15)
    @Column(nullable = false)
    private String password;

    //사용자 이름
    @Length(min = 4, max = 10)
    @Column(unique = true, nullable = false)
    private String username;

    //이메일
    @Column(unique = true, nullable = false)
    private String email;

    //한줄소개
    private String introduce;

    //사용자 회원 상태(정상, 탈퇴)
    private String status;

}
