package com.green.gallery_jwt_jpa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(
    uniqueConstraints = {
        @UniqueConstraint(
           columnNames = { "member_id" }
           )
       }
    ) // unique 부여시 @Table, uniqueConstraints, @UniqueConstraint, columnNames 순으로 작성
public class Orders extends Created {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Members members;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 500)
    private String address;

    @Column(nullable = false, length = 10)
    private String payment;

    @Column(nullable = true, length = 16)
    private long cardNumber;

    @Column(nullable = false, length = 20)
    private long amount;
}
