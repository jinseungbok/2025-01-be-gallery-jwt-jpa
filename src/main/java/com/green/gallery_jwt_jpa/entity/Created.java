package com.green.gallery_jwt_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
// 이 클래스를 상속하면 createdAt 컬럼을 가지게 된다. 부모 역할, 상속 처리
@EntityListeners(AuditingEntityListener.class)
// 이벤트 연결, insert가 될 때 현재일시 값 넣을 수 있도록 감시(front = wathch)
// Listeners = 이벤트가 따라온다
public class Created {
    @CreatedDate // INSERT 때 createdAt 값 가질 수 있도록 함
    @Column(nullable = false) // NOT NULL
    private LocalDateTime created;
}
