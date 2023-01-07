package ru.kata.spring.boot_security.demo.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "roles")
public class Role {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name ="role_id" ),
            inverseJoinColumns = @JoinColumn(name ="user_id" ))
    private List<User> users;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;


    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
