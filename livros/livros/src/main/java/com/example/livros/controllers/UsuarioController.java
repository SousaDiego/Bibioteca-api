package com.example.livros.controllers;


import com.example.livros.domain.livro.Livro;
import com.example.livros.domain.livro.LivroRequestDTO;
import com.example.livros.domain.livro.LivroResponseDTO;
import com.example.livros.domain.usuario.Usuario;
import com.example.livros.domain.usuario.UsuarioRequestDTO;
import com.example.livros.domain.usuario.UsuarioResponseDTO;
import com.example.livros.repositories.LivroRepository;
import com.example.livros.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getAll(){
        List<Usuario> usuarioList = repository.findAll();
        return usuarioList;
    }

    @PostMapping("/save")
    public ResponseEntity saveUsuarios(@RequestBody UsuarioRequestDTO data) {
        Usuario usuario = new Usuario(data);
        repository.save(usuario);
        return ResponseEntity.ok().build();
    }

    //Tanto no post quanto no delete a url é "localhost:8080/livros/id do livro a ser editado ou deletado
    //No caso do post, no body da requisição vem um novo titulo, ou outras coisas que devem ser atualizadas;
    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity editUsuarios(@PathVariable String id, @RequestBody UsuarioRequestDTO data) {
        Optional<Usuario> optionalUsuario = repository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNome(data.nome());
            return ResponseEntity.ok(usuario);
        } else {
            throw new EntityNotFoundException();
        }

    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deleteUsuarios(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity getByNome(@PathVariable String nome){
        List<UsuarioResponseDTO> responseUsuario = repository.findByNome(nome).stream().map(UsuarioResponseDTO::new).toList();
        return ResponseEntity.ok(responseUsuario);
    }

}