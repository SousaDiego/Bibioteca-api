package com.example.livros.domain.livrosEmprestimo;

import com.example.livros.domain.livro.Livro;
import com.example.livros.domain.usuario.Usuario;

public record EmprestimoResponseDTO(String id, String livro, String usuario) {

    public EmprestimoResponseDTO(Emprestimo emprestimo) {
        this(emprestimo.getId(), emprestimo.getLivro(), emprestimo.getUsuario());
    }
}
