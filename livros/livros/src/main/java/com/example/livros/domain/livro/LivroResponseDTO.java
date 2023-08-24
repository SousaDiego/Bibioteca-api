package com.example.livros.domain.livro;

import com.example.livros.domain.livro.Livro;

public record LivroResponseDTO(String id, String titulo, String autor, int quantidade) {

    public LivroResponseDTO(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getQuantidade());
    }
}
