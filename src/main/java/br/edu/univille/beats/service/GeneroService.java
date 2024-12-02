package br.edu.univille.beats.service;

import br.edu.univille.beats.entity.Genero;
import br.edu.univille.beats.repositorio.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> obterTodos() {
        return generoRepository.findAll();
    }

    public Optional<Genero> obterPeloId(long id) {
        return generoRepository.findById(id);
    }

    public void excluir(Genero genero) {
        generoRepository.delete(genero);
    }

    public Genero salvar(Genero genero) {
        return generoRepository.save(genero);
    }
}
