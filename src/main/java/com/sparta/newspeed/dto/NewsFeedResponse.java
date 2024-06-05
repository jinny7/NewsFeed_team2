package com.sparta.newspeed.dto;

import lombok.Getter;

@Getter
public class NewsFeedResponse {
    private final long userId;
    private String contents;

    public NewsFeedResponse(long userId, String contents){
        this.userId = userId;
        this.contents = contents;
    }
}

