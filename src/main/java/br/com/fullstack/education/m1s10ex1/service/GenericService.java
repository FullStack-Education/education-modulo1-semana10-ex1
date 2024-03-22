package br.com.fullstack.education.m1s10ex1.service;

import java.util.List;

public interface GenericService<T> {

    T criar(T entity);

    List<T> buscarTodos();

    T buscarPorId(Long id);

    T alterar(Long id, T entity);

    void excluir(Long id);

}
