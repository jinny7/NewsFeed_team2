package com.sparta.newspeed.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class NewsFeed extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long newsFeedId; // J : 뉴스피드 클래스의 아이디를 명확하게 하기 위해 id가 아닌 newsFeedId로 수정하여 사용.

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "userId")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String contents;


}
