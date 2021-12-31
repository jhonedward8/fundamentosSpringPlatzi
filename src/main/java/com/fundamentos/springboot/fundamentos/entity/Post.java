package com.fundamentos.springboot.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Post(String descripcion, User user) {
        this.descripcion = descripcion;
        this.user = user;
    }
}
