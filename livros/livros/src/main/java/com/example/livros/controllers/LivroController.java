package com.example.livros.controllers;


import com.example.livros.domain.livro.Livro;
import com.example.livros.domain.livro.LivroRequestDTO;
import com.example.livros.domain.livro.LivroResponseDTO;
import com.example.livros.repositories.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @GetMapping
    public List<Livro> getAll() {
        List<Livro> livroList = repository.findAll();
        return livroList;
    }

    public ResponseEntity getLivros() {
        List<LivroResponseDTO> responseLivros = repository.findAll().stream().map(LivroResponseDTO::new).toList();
        return ResponseEntity.ok(responseLivros);
    }

    @PostMapping("/save")
    public ResponseEntity saveLivros(@RequestBody LivroRequestDTO data) {
        Livro livro = new Livro(data);
        repository.save(livro);
        return ResponseEntity.ok().build();
    }

    //Tanto no post quanto no delete a url é "localhost:8080/livros/id do livro a ser editado ou deletado
    //No caso do post, no body da requisição vem um novo titulo, ou outras coisas que devem ser atualizadas;
    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity editLivros(@PathVariable String id, @RequestBody LivroRequestDTO data) {
        Optional<Livro> optionalLivro = repository.findById(id);
        if (optionalLivro.isPresent()) {
            Livro livro = optionalLivro.get();
            livro.setTitulo(data.titulo());
            livro.setAutor(data.autor());
            return ResponseEntity.ok(livro);
        } else {
            throw new EntityNotFoundException();
        }

    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deleteLivros(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/titulo/{titulo}")
        public ResponseEntity getByTitulo(@PathVariable String titulo){
        List<LivroResponseDTO> responseLivro = repository.findByTitulo(titulo).stream().map(LivroResponseDTO::new).toList();
        return ResponseEntity.ok(responseLivro);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity getByAutor(@PathVariable String autor){
        List<LivroResponseDTO> responseLivro = repository.findByAutor(autor).stream().map(LivroResponseDTO::new).toList();
        return ResponseEntity.ok(responseLivro);
    }
}

