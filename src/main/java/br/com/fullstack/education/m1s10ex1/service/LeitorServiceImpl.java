package br.com.fullstack.education.m1s10ex1.service;

import br.com.fullstack.education.m1s10ex1.entity.LeitorEntity;
import br.com.fullstack.education.m1s10ex1.exception.NotFoundException;
import br.com.fullstack.education.m1s10ex1.repository.LeitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitorServiceImpl implements LeitorService {

    private final LeitorRepository repository;

    public LeitorServiceImpl(LeitorRepository repository) {
        this.repository = repository;
    }

    @Override
    public LeitorEntity criar(LeitorEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public List<LeitorEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public LeitorEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Leitor não encontrado com id:" + id));
    }

    @Override
    public LeitorEntity alterar(Long id, LeitorEntity entity) {
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
