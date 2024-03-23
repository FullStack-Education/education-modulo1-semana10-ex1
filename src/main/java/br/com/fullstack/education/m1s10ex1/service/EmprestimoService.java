package br.com.fullstack.education.m1s10ex1.service;

import br.com.fullstack.education.m1s10ex1.dto.EmprestimoFiltro;
import br.com.fullstack.education.m1s10ex1.entity.EmprestimoEntity;

import java.util.List;

public interface EmprestimoService extends GenericService<EmprestimoEntity> {

    List<EmprestimoEntity> buscarTodos(EmprestimoFiltro filtro);

}
