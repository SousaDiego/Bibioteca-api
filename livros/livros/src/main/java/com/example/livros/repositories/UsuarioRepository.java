package com.example.livros.repositories;

import com.example.livros.domain.livro.Livro;
import com.example.livros.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    List<Usuario> findByNome(String nome);
}
