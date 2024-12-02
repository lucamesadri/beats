package br.edu.univille.beats.controller;

import br.edu.univille.beats.entity.Usuario;
import br.edu.univille.beats.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/loginUsuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String login(@RequestParam("email") String email,
                        @RequestParam("senha") String senha,
                        RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.authenticate(email, senha);

        if (usuario != null) {
            redirectAttributes.addFlashAttribute("usuario", usuario);
            return "redirect:/profile";
        }

        redirectAttributes.addFlashAttribute("error", "Email ou senha inválidos.");
        return "redirect:/profile";
    }
}
