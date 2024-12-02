package br.edu.univille.beats.service;

import br.edu.univille.beats.entity.Musica;
import br.edu.univille.beats.repositorio.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public Musica save(Musica musica) {
        return musicaRepository.save(musica);
    }

    public List<Musica> getMusicasByUsuario(Long usuarioId) {
        return musicaRepository.findAllByCriador_Id(usuarioId);
    }

    public List<Musica> getMusicasFavoritas(Long usuarioId) {
        return musicaRepository.findMusicasFavoritasByUsuario(usuarioId);
    }

    public Optional<Musica> findById(Long id) {
        return musicaRepository.findById(id);
    }
}
