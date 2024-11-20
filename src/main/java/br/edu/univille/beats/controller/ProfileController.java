package br.edu.univille.beats.controller;

import br.edu.univille.beats.entity.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        Usuario usuario = (Usuario) model.asMap().get("usuario");
        if (usuario == null) {
            return "redirect:/loginUsuario"; // Redireciona para o login caso o usuário não esteja autenticado
        }
        model.addAttribute("usuario", usuario);
        return "main/profile"; // Página de perfil
    }
}