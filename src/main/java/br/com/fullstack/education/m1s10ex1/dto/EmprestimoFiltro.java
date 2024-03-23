package br.com.fullstack.education.m1s10ex1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmprestimoFiltro {
    private String nomeLeitor;
    private String tituloLivro;
    private LocalDate dataEmprestimoInicio;
    private LocalDate dataEmprestimoFim;
}
