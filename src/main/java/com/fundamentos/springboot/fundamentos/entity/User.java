package com.fundamentos.springboot.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false, unique = true)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50, unique = true)
    private String email;

    private LocalDate fecah;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    public User(String name, String email, LocalDate birthdate, List<Post> posts) {
        this.name = name;
        this.email = email;
        this.fecah = birthdate;
        this.posts = posts;
    }
}

