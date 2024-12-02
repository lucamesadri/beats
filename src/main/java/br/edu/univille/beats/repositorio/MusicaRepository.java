package br.edu.univille.beats.repositorio;

import br.edu.univille.beats.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findByNomeContaining(String nome);

    List<Musica> findByGeneroNome(String generoNome);

    List<Musica> findByAlbumId(Long albumId);

    List<Musica> findAllByCriador_Id(Long criadorId);

    @Query("SELECT m FROM Musica m JOIN m.usuariosFavoritaram u WHERE u.id = :usuarioId")
    List<Musica> findMusicasFavoritasByUsuario(@Param("usuarioId") Long usuarioId);
}
