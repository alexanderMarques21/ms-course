package br.com.hroauth.entities;


import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Set<Role> role = new HashSet<>();

    public User() {
    }

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRole() {
        return role;
    }
}
