package br.com.fullstack.education.m1s10ex1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "emprestimos")
public class EmprestimoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "leitor_id", nullable = false)
    private LeitorEntity leitor;

    @Column(nullable = false)
    private LocalDate dataEmprestimo = LocalDate.now();

    private LocalDate dataDevolucao;

    @OneToMany(mappedBy = "emprestimo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmprestimoLivroEntity> livrosEmprestados;

}
