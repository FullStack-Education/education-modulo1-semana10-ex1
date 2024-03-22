package br.com.fullstack.education.m1s10ex1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "emprestimo_livros")
public class EmprestimoLivroEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "emprestimo_id", nullable = false)
    private EmprestimoEntity emprestimo;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private LivroEntity livro;

}
