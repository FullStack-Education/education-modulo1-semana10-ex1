package br.com.fullstack.education.m1s10ex1.controller;

import br.com.fullstack.education.m1s10ex1.entity.LivroEntity;
import br.com.fullstack.education.m1s10ex1.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LivroEntity>> get() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<LivroEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    /* Sempre retornar Status HTTP 201 em métodos POST (em caso de sucesso) */
    @PostMapping
    public ResponseEntity<LivroEntity> post(@RequestBody LivroEntity livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(livro));
    }

    @PutMapping("{id}")
    public ResponseEntity<LivroEntity> put(@PathVariable Long id, @RequestBody LivroEntity livro) {
        return ResponseEntity.ok().body(service.alterar(id, livro));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
