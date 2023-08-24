package com.example.livros.domain.usuario;

import com.example.livros.domain.livro.Livro;

public record UsuarioResponseDTO(String id, String nome) {
    public UsuarioResponseDTO(Usuario usuario) {this(usuario.getId(), usuario.getNome());}
}
