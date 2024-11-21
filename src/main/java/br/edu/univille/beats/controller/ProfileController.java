package br.edu.univille.beats.controller;

import br.edu.univille.beats.entity.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario") // Armazena o "usuario" na sessão
public class ProfileController {

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        // Obtém o usuário da sessão
        Usuario usuario = (Usuario) model.getAttribute("usuario");


        if (usuario == null) {

            return "redirect:/loginUsuario";
        }
        model.addAttribute("usuario", usuario);


        return "main/profile";
    }
}
