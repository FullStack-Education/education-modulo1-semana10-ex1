package br.com.fullstack.education.m1s10ex1.controller;

import br.com.fullstack.education.m1s10ex1.entity.LeitorEntity;
import br.com.fullstack.education.m1s10ex1.service.LeitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leitores")
public class LeitorController {

    private final LeitorService service;

    public LeitorController(LeitorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LeitorEntity>> get() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<LeitorEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    /* Sempre retornar Status HTTP 201 em métodos POST (em caso de sucesso) */
    @PostMapping
    public ResponseEntity<LeitorEntity> post(@RequestBody LeitorEntity leitor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(leitor));
    }

    @PutMapping("{id}")
    public ResponseEntity<LeitorEntity> put(@PathVariable Long id, @RequestBody LeitorEntity leitor) {
        return ResponseEntity.ok().body(service.alterar(id, leitor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
