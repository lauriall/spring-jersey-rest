package com.springjersey.rest.usermanagement.entity;

import javax.persistence.*;

@Entity
public class Role {

    private Long id;
    private Long userId;
    private String role;

    public Role() {}

    public Role(String role) {
        this.role = role;
    }

    public Role(Long id, Long userId, String role) {
        this.id = id;
        this.userId = userId;
        this.role = role;
    }

    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "SEQ_ROLE", sequenceName = "SEQ_ROLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROLE")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
