package br.edu.univille.beats.repositorio;

import br.edu.univille.beats.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByNomeContaining(String nome);
    List<Album> findByArtistasId(Long artistaId);
}
