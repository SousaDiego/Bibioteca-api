package com.example.livros.domain.livrosEmprestimo;

import com.example.livros.domain.livro.Livro;
import com.example.livros.domain.usuario.Usuario;

public record EmprestimoRequestDTO(String livro, String usuario) {
}
