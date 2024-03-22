package br.com.fullstack.education.m1s10ex1.repository;

import br.com.fullstack.education.m1s10ex1.entity.LeitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<LeitorEntity, Long> {
}
