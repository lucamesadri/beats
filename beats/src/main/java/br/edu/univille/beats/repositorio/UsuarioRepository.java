package br.edu.univille.beats.repositorio;

import br.edu.univille.beats.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNomeContaining(String nome);
    List<Usuario> findByMusicasFavoritasId(Long musicaId);
}
