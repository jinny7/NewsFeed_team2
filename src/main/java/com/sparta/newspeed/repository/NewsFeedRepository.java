package com.sparta.newspeed.repository;

import com.sparta.newspeed.entity.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {
}
