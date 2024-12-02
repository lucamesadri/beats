package br.edu.univille.beats.controller;

import br.edu.univille.beats.dto.ImportMusicaRequest;
import br.edu.univille.beats.entity.Genero;
import br.edu.univille.beats.entity.Musica;
import br.edu.univille.beats.entity.Usuario;
import br.edu.univille.beats.service.GeneroService;
import br.edu.univille.beats.service.MusicaService;
import br.edu.univille.beats.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/musicas")
public class MusicaController {

    private final UsuarioService usuarioService;
    private final GeneroService generoService;
    private final MusicaService musicaService;

    @Autowired
    public MusicaController(UsuarioService usuarioService, GeneroService generoService, MusicaService musicaService) {
        this.usuarioService = usuarioService;
        this.generoService = generoService;
        this.musicaService = musicaService;
    }

    @GetMapping("/import")
    public String importMusicaPage(Model model) {
        model.addAttribute("generos", generoService.obterTodos());
        return "main/importMusic";
    }

    @PostMapping("/import")
    public String importMusica(@ModelAttribute ImportMusicaRequest request, Model model) {
        try {
            Usuario criador = usuarioService.findById(request.getUsuarioId());
            if (criador == null) {
                model.addAttribute("error", "Usuário não encontrado.");
                return "main/importMusic";  // Volta para a página de importação
            }

            Genero genero = generoService.obterPeloId(request.getGeneroId()).orElse(null);
            if (genero == null) {
                model.addAttribute("error", "Gênero não encontrado.");
                return "main/importMusic";  // Volta para a página de importação
            }

            Musica novaMusica = new Musica();
            novaMusica.setNome(request.getNome());
            novaMusica.setGenero(genero);
            novaMusica.setCriador(criador);

            Musica salva = musicaService.save(novaMusica);
            model.addAttribute("success", "Música importada com sucesso!");
            return "main/importMusic";

        } catch (Exception e) {
            model.addAttribute("error", "Erro ao importar música.");
            return "main/importMusic";
        }
    }
}
