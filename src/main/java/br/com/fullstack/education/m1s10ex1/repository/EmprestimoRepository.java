package br.com.fullstack.education.m1s10ex1.repository;

import br.com.fullstack.education.m1s10ex1.entity.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {
}
