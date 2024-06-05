package com.sparta.newspeed.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class TimeStamped {
    //생성일자
    @CreatedDate
    @Column(updatable = false)
    private LocalDate createdDate;
    //수정일자
    @LastModifiedDate
    @Column
    private LocalDate modifiedDate;

    //상태 변경 시간
    @LastModifiedDate
    @Column
    private LocalDate modifiedAt;
}
