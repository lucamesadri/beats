package br.edu.univille.beats.controller;

import br.edu.univille.beats.entity.Genero;
import br.edu.univille.beats.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService service;

    // Página inicial com a lista de gêneros
    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("genero/index");
        mv.addObject("lista", service.obterTodos());
        return mv;
    }

    // Página para criar um novo gênero
    @GetMapping("/novo")
    public ModelAndView novo() {
        var mv = new ModelAndView("genero/novo");
        mv.addObject("elemento", new Genero());
        return mv;
    }

    // Página para editar um gênero existente
    @GetMapping("/{id}")
    public ModelAndView editar(@PathVariable long id) {
        var mv = new ModelAndView("genero/editar");
        var opt = service.obterPeloId(id);
        if (opt.isPresent()) {
            mv.addObject("elemento", opt.get());
            return mv;
        }
        return new ModelAndView("redirect:/genero");
    }

    // Excluir um gênero
    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable long id) {
        var mv = new ModelAndView("redirect:/genero");
        var opt = service.obterPeloId(id);
        if (opt.isPresent()) {
            service.excluir(opt.get());
        }
        return mv;
    }

    // Salvar novo gênero ou atualizar um existente
    @PostMapping("/salvar")
    public ModelAndView salvarNovo(@ModelAttribute("elemento") Genero genero) {
        try {
            service.salvar(genero);
            return new ModelAndView("redirect:/genero");
        } catch (Exception e) {
            var mv = new ModelAndView("genero/novo");
            mv.addObject("elemento", genero);
            mv.addObject("erro", e.getMessage());
            return mv;
        }
    }
}
