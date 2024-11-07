package br.edu.univille.beats.repositorio;

import br.edu.univille.beats.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    List<Artista> findByNomeContaining(String nome);
    List<Artista> findByMusicasFavoritasId(Long musicaId);
}
