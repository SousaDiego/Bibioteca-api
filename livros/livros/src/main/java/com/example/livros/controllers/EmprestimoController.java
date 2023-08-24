package com.example.livros.controllers;

import com.example.livros.domain.livro.Livro;
import com.example.livros.domain.livro.LivroRequestDTO;
import com.example.livros.domain.livro.LivroResponseDTO;
import com.example.livros.domain.livrosEmprestimo.Emprestimo;
import com.example.livros.domain.livrosEmprestimo.EmprestimoRequestDTO;
import com.example.livros.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository repository;

    @GetMapping
    public  ResponseEntity getAll(){
        List<Emprestimo> emprestimosList = repository.findAll();
        return ResponseEntity.ok(emprestimosList);
    }
    @PostMapping("/save")
    public ResponseEntity saveEmprestimos(@RequestBody EmprestimoRequestDTO data) {
        Long emprestimosCount = repository.countEmprestimosByUsuario(data.getUsuarioId());
        if (emprestimosCount < 2) {
            Emprestimo emprestimo = new Emprestimo(data);
            repository.save(emprestimo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Usuário atingiu o limite de empréstimos.");
        }
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deleteLivroEmprestimo(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
