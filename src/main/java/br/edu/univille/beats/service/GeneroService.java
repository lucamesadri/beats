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

    // Obter todos os gêneros
    public List<Genero> obterTodos() {
        return generoRepository.findAll();
    }

    // Obter um gênero pelo id
    public Optional<Genero> obterPeloId(long id) {
        return generoRepository.findById(id);
    }

    // Excluir um gênero
    public void excluir(Genero genero) {
        generoRepository.delete(genero);
    }

    // Salvar ou atualizar um gênero
    public Genero salvar(Genero genero) {
        return generoRepository.save(genero);
    }
}
