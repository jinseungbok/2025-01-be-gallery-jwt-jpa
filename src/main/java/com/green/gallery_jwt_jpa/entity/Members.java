package com.green.gallery_jwt_jpa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity // 모든 Entity는 PK를 받아야 함
@EqualsAndHashCode // 모든 Entity는 EqualsAndHashCode를 주어야 함
public class Members extends Created {
    @Id // Primary Key(PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Auto Increment
    private Long id;

    @Column(nullable = false, length = 50) // NOT NULL
    private String name;

    @Column(nullable = false, length = 50)
    private String loginId; // 자동으로 snake case 됨

    @Column(nullable = false, length = 100)
    private String loginPw;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL) // 양방향
    private List<MembersRoles> roles = new ArrayList<>();

    public void addRole(String roleName) {
        MembersRolesIds membersRolesIds = new MembersRolesIds(roleName);
        MembersRoles membersRoles = new MembersRoles();
        membersRoles.setMembers(this);
        membersRoles.setMembersRolesIds(membersRolesIds);

        this.roles.add(membersRoles);
    }
}
