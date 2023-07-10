package com.example.post.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;

    public User(Long id,String userName,String password) {
        this.id=id;
        this.userName = userName;
        this.password = password;
    }



    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, orphanRemoval = false)
    private List<Post> posts;


}