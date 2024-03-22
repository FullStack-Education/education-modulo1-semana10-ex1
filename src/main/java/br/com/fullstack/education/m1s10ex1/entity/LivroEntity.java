package br.com.fullstack.education.m1s10ex1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "livros")
public class LivroEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(length = 20)
    private String autor;

    @Column(nullable = false)
    private Integer anoPublicacao;

}
