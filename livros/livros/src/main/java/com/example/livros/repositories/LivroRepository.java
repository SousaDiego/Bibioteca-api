package com.example.livros.repositories;

import com.example.livros.domain.livro.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, String> {
     List<Livro> findByTitulo(String titulo);
     List<Livro> findByAutor(String autor);
}