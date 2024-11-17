package br.edu.univille.beats.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.univille.beats.entity.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar usuário por email
    List<Usuario> findByNomeContaining(String nome);
    List<Usuario> findByMusicasFavoritasId(Long musicaId);
    Usuario findByEmail(String email);
}

