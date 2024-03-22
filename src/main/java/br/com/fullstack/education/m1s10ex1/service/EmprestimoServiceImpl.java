package br.com.fullstack.education.m1s10ex1.service;

import br.com.fullstack.education.m1s10ex1.entity.EmprestimoEntity;
import br.com.fullstack.education.m1s10ex1.exception.NotFoundException;
import br.com.fullstack.education.m1s10ex1.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    private final EmprestimoRepository repository;

    public EmprestimoServiceImpl(EmprestimoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmprestimoEntity criar(EmprestimoEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public List<EmprestimoEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public EmprestimoEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Empréstimo não encontrado com id:" + id));
    }

    @Override
    public EmprestimoEntity alterar(Long id, EmprestimoEntity entity) {
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
