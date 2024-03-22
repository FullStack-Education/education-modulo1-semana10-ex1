package br.com.fullstack.education.m1s10ex1.service;

import br.com.fullstack.education.m1s10ex1.entity.LivroEntity;
import br.com.fullstack.education.m1s10ex1.exception.NotFoundException;
import br.com.fullstack.education.m1s10ex1.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;

    public LivroServiceImpl(LivroRepository repository) {
        this.repository = repository;
    }

    @Override
    public LivroEntity criar(LivroEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public List<LivroEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public LivroEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Livro não encontrado com id:" + id));
    }

    @Override
    public LivroEntity alterar(Long id, LivroEntity entity) {
        buscarPorId(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
