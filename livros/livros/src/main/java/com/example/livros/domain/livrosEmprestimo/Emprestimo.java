package com.example.livros.domain.livrosEmprestimo;

import com.example.livros.domain.livro.Livro;
import com.example.livros.domain.livro.LivroRequestDTO;
import com.example.livros.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "livrosemprestimo")
@Entity(name = "livrosemprestimo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Emprestimo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "livro")
    private String livro;

    @Column(name = "usuario")
    private String usuario;

    public Emprestimo(EmprestimoRequestDTO data) {this.livro = data.livro(); this.usuario = data.usuario();}


}
