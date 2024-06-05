package com.sparta.newspeed.dto;

import lombok.Getter;

@Getter
public class NewsFeedCreateRequest {
    private String contents;
    private String userId;
}
