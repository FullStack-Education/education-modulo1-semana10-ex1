package br.com.fullstack.education.m1s10ex1.repository;

import br.com.fullstack.education.m1s10ex1.entity.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {

    // Consultar por intervalo de data de empréstimo
    List<EmprestimoEntity> findByDataEmprestimoBetweenOrderByDataEmprestimo(LocalDate inicio, LocalDate fim);

    @Query("SELECT e FROM EmprestimoEntity e WHERE e.leitor.nome ILIKE %:nomeLeitor% ORDER BY e.dataEmprestimo DESC")
    List<EmprestimoEntity> findByLeitorNomeContainingIgnoreCaseOrderByDataEmprestimoDesc(String nomeLeitor);

    @Query("SELECT DISTINCT el.emprestimo " +
            "FROM EmprestimoLivroEntity el " +
            "WHERE el.livro.titulo ILIKE %:tituloLivro% " +
            "ORDER BY el.emprestimo.dataEmprestimo DESC")
    List<EmprestimoEntity> findByLivroTituloContainingIgnoreCaseOrderByDataEmprestimoDesc(String tituloLivro);

}
