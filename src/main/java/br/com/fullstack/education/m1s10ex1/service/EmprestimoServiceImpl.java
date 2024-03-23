package br.com.fullstack.education.m1s10ex1.service;

import br.com.fullstack.education.m1s10ex1.dto.EmprestimoFiltro;
import br.com.fullstack.education.m1s10ex1.entity.EmprestimoEntity;
import br.com.fullstack.education.m1s10ex1.entity.EmprestimoLivroEntity;
import br.com.fullstack.education.m1s10ex1.entity.LeitorEntity;
import br.com.fullstack.education.m1s10ex1.entity.LivroEntity;
import br.com.fullstack.education.m1s10ex1.exception.NotFoundException;
import br.com.fullstack.education.m1s10ex1.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    private final LivroService livroService;
    private final LeitorService leitorService;
    private final EmprestimoRepository repository;

    public EmprestimoServiceImpl(EmprestimoRepository repository, LeitorService leitorService, LivroService livroService) {
        this.repository = repository;
        this.leitorService = leitorService;
        this.livroService = livroService;
    }

    @Override
    public EmprestimoEntity criar(EmprestimoEntity emprestimo) {
        emprestimo.setId(null);

        LeitorEntity leitor = leitorService.buscarPorId(emprestimo.getLeitor().getId());
        emprestimo.setLeitor(leitor);

        for (EmprestimoLivroEntity el : emprestimo.getLivrosEmprestados()) {
            el.setEmprestimo(emprestimo);
            LivroEntity livro = livroService.buscarPorId(el.getLivro().getId());
            el.setLivro(livro);
        }

        return repository.save(emprestimo);
    }

    @Override
    public List<EmprestimoEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public List<EmprestimoEntity> buscarTodos(EmprestimoFiltro filtro) {
        if (StringUtils.hasText(filtro.getTituloLivro())) {
            return repository.findByLivroTituloContainingIgnoreCaseOrderByDataEmprestimoDesc(
                    filtro.getTituloLivro()
            );
        }
        if (StringUtils.hasText(filtro.getNomeLeitor())) {
            return repository.findByLeitorNomeContainingIgnoreCaseOrderByDataEmprestimoDesc(
                    filtro.getNomeLeitor()
            );
        }
        if (filtro.getDataEmprestimoInicio() != null  && filtro.getDataEmprestimoFim() != null) {
            return repository.findByDataEmprestimoBetweenOrderByDataEmprestimo(
                    filtro.getDataEmprestimoInicio(),
                    filtro.getDataEmprestimoFim()
            );
        }
        return buscarTodos();
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
