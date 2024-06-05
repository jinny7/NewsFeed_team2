package com.sparta.newspeed.repository;

import com.sparta.newspeed.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
