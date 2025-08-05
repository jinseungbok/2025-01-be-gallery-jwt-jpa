package com.green.gallery_jwt_jpa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class MembersRoles {
    @EmbeddedId
    private MembersRolesIds membersRolesIds;

    // 관계 설정
    // CascadeType.PERSIST 영속성 전이
    // CascadeType.REMOVE 부모 영속성이 delete되면 본인도 delete
    // 영속성이 있는지 여부 = 관리하고 있느냐의 차이
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
    @MapsId("memberId")
    private Members members;

}
