package com.springjersey.rest.usermanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    
    private Long id;
    private String name;
    private String email;
    private List<Role> roles;

    public User() { }

    public User(String name, String email, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public User(Long id, String name, String email, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }
    
    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "SEQ_USER", sequenceName = "SEQ_USER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "USER_ID")
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
}
