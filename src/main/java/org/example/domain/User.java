package org.example.domain;

import javax.persistence.*;


/**
 * Created by Evgeny Kuzmin on 17.05.2017.
 * Пользователь.
 */
@Entity
@Inheritance
public class User {
    private Integer id;
    @Column(unique = true)
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
