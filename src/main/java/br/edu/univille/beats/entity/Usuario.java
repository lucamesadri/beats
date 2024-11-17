package br.edu.univille.beats.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;  // Senha armazenada em texto simples
    @ManyToMany
    private List<Musica> musicasFavoritas;

    @OneToMany(mappedBy = "usuario")
    private List<Curtida> curtidas;
}
