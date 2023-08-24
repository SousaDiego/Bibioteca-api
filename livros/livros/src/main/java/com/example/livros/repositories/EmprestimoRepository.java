package com.example.livros.repositories;

import com.example.livros.domain.livro.Livro;
import com.example.livros.domain.livrosEmprestimo.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, String> {

    @Query("SELECT COUNT(e) FROM livrosemprestimo e WHERE e.usuario = :id")
    Long countEmprestimosByUsuario(String id);
}
