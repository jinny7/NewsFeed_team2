package com.sparta.newspeed.controller;

import com.sparta.newspeed.dto.NewsFeedCreateRequest;
import com.sparta.newspeed.dto.NewsFeedDeleteRequest;
import com.sparta.newspeed.dto.NewsFeedResponse;
import com.sparta.newspeed.service.NewsFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user/newsfeed")
@RequiredArgsConstructor
public class NewsFeedController {

    public final NewsFeedService newsFeedService;

    //게시물 작성
    @PostMapping
    public ResponseEntity<String> createNewsFeed(@RequestBody NewsFeedCreateRequest request) {
//        System.out.println(request.getContents()); 확인용
        Long newsFeedId = newsFeedService.create(request);
        return ResponseEntity.ok(newsFeedId.toString()+"게시글 작성이 완료되었습니다.");
    }

    //전체 게시물 조최 : 누구든 조회 가능
    @GetMapping
    public ResponseEntity<List<NewsFeedResponse>> findAll(){
        List<NewsFeedResponse> response = newsFeedService.findAll();
        return ResponseEntity.ok(response);
    }
    //개별 게시물 조회 : 누구든 조회 가능
    @GetMapping("/{newsFeedId}")
    public ResponseEntity<NewsFeedResponse> findByID(@PathVariable(name = "newsFeedId") Long newsFeedId) {
        NewsFeedResponse response = newsFeedService.findById(newsFeedId);
        return ResponseEntity.ok(response);
    }

//U

    @DeleteMapping("/{newsFeedId}")
    public ResponseEntity<String> deleteByID(@PathVariable(name = "newsFeedId") Long newsFeedId) {
    newsFeedService.delete(newsFeedId);
    return ResponseEntity.ok("게시글이 삭제되었습니다.");
        }
    }


