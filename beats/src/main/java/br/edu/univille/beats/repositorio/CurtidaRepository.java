package br.edu.univille.beats.repositorio;

import br.edu.univille.beats.entity.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Date;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {
    List<Curtida> findByUsuarioId(Long usuarioId);
    List<Curtida> findByMusicaId(Long musicaId);
    List<Curtida> findByDataBetween(Date inicio, Date fim);
}
