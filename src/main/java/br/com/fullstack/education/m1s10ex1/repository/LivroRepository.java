package br.com.fullstack.education.m1s10ex1.repository;

import br.com.fullstack.education.m1s10ex1.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
}
