package br.edu.univille.beats.service;

import br.edu.univille.beats.entity.Musica;
import br.edu.univille.beats.repositorio.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    // Para buscar músicas criadas por um usuário
    public List<Musica> getMusicasByUsuario(Long usuarioId) {
        return musicaRepository.findAllByCriador_Id(usuarioId);
    }

    // Para buscar músicas favoritas de um usuário
    public List<Musica> getMusicasFavoritas(Long usuarioId) {
        return musicaRepository.findMusicasFavoritasByUsuario(usuarioId);
    }
}
