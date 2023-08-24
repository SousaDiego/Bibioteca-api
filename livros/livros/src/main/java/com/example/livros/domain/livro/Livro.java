package com.example.livros.domain.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "livros")
@Entity(name = "livros")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "quantidade")
    private int quantidade;

    public Livro(LivroRequestDTO data) {this.titulo = data.titulo(); this.autor = data.autor(); this.quantidade = data.quantidade(); }

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public void setAutor(String autor) {this.autor = autor;}

    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

}
