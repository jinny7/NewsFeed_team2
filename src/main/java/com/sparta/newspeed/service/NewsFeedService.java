package com.sparta.newspeed.service;

import com.sparta.newspeed.dto.NewsFeedCreateRequest;
//import com.sparta.newspeed.dto.NewsFeedDeleteRequest;
import com.sparta.newspeed.dto.NewsFeedResponse;
import com.sparta.newspeed.entity.NewsFeed;
import com.sparta.newspeed.entity.User;
import com.sparta.newspeed.repository.NewsFeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NewsFeedService {
    private final NewsFeedRepository repository;

    public Long create(NewsFeedCreateRequest request) {

        User user = new User();
        user.setUserId(Long.parseLong(request.getUserId()));
        NewsFeed newsFeed = new NewsFeed();
        newsFeed.setUser(user);
        newsFeed.setContents(request.getContents());

        return repository.save(newsFeed).getNewsFeedId();
    }

    //단일 게시글 조회
    public NewsFeedResponse findById(Long newsFeedId) {
        NewsFeed newsFeed = findNewsFeedById(newsFeedId);

        return new NewsFeedResponse(newsFeed.getNewsFeedId(), newsFeed.getContents());
    }

    private NewsFeed findNewsFeedById(Long newsFeedId) {
        return repository.findById(newsFeedId)
                .orElseThrow(() -> new IllegalArgumentException("NewsFeed에서 해당 ID를 찾을 수 없습니다: " + newsFeedId));

        //인가 if 추가부분
    }

    public void delete(Long newsFeedId) {
        repository.deleteById(newsFeedId);
    }

    public List<NewsFeedResponse> findAll() {
        List<NewsFeed> newsFeeds = repository.findAll();
        List<NewsFeedResponse> newsFeedResponseList = new ArrayList<>();
        for (NewsFeed newsFeed : newsFeeds) {
            NewsFeedResponse response = new NewsFeedResponse(newsFeed.getNewsFeedId(), newsFeed.getContents());
            newsFeedResponseList.add(response);
        }
        return newsFeedResponseList;
    }

    public void update(Long newsFeedId, NewsFeedCreateRequest request) {
        NewsFeed newsFeed = findNewsFeedById(newsFeedId);
        newsFeed.setContents(request.getContents());
        repository.save(newsFeed);
    }
}
