package br.edu.univille.beats.repositorio;

import br.edu.univille.beats.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    // Buscar músicas que contenham o nome fornecido
    List<Musica> findByNomeContaining(String nome);

    // Buscar músicas por nome do gênero
    List<Musica> findByGeneroNome(String generoNome);

    // Buscar músicas por ID do álbum
    List<Musica> findByAlbumId(Long albumId);

    // Buscar músicas criadas por um usuário específico
    List<Musica> findAllByCriador_Id(Long criadorId);

    // Consulta personalizada para músicas favoritas de um usuário
    @Query("SELECT m FROM Musica m JOIN m.usuariosFavoritaram u WHERE u.id = :usuarioId")
    List<Musica> findMusicasFavoritasByUsuario(@Param("usuarioId") Long usuarioId);
}
