package br.edu.univille.beats.controller;

import br.edu.univille.beats.entity.Musica;
import br.edu.univille.beats.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @GetMapping("/minhas-musicas")
    public String minhasMusicas(Model model, Principal principal) {
        // Obtém o usuário logado
        Long usuarioId = 1L; // Substitua por lógica para pegar o ID real do usuário logado

        // Busca músicas criadas pelo usuário
        List<Musica> musicas = musicaService.getMusicasByUsuario(usuarioId);
        model.addAttribute("musicas", musicas);

        return "minhas-musicas"; // Nome do template HTML a ser renderizado
    }
}
