package br.edu.univille.beats.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Genero genero;

    @ManyToOne
    private Album album;

    @ManyToMany(mappedBy = "musicasFavoritas")
    private List<Usuario> usuariosFavoritaram;
}
