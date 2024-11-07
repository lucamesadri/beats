package br.edu.univille.beats.service;

import br.edu.univille.beats.entity.Genero;
import br.edu.univille.beats.repositorio.GeneroRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository repository;
    public Optional<Genero> obterPeloId(long id){
        return repository.findById(id);
    }
    public List<Genero> obterTodos(){
        return repository.findAll(Sort.by("nome"));
    }
    public void salvar(Genero genero) {
        if(Strings.isBlank(genero.getNome())){
            throw new RuntimeException("Nome não informado.");
        }
        repository.save(genero);
    }
    public void excluir(Genero genero) {
        repository.delete(genero);
    }
}
