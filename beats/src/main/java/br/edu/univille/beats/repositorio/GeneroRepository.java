package br.edu.univille.beats.repositorio;

import br.edu.univille.beats.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Genero findByNome(String nome);
}
