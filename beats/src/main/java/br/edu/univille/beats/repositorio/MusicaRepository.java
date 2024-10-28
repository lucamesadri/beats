package br.edu.univille.beats.repositorio;

import br.edu.univille.beats.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    List<Musica> findByNomeContaining(String nome);
    List<Musica> findByGeneroNome(String generoNome);
    List<Musica> findByAlbumId(Long albumId);
}
