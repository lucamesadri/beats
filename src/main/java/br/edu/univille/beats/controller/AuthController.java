package br.edu.univille.beats.controller;

import br.edu.univille.beats.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario") // Define que o atributo "usuario" será armazenado na sessão
public class AuthController {

    @Autowired
    private AuthService authService;

    // Exibe o formulário de login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login/login"; // Retorna o template de login
    }

    // Processa o login do usuário
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        Model model) {
        // Chama o serviço de autenticação
        boolean isAuthenticated = authService.authenticate(email, senha);

        if (isAuthenticated) {
            // Supondo que o serviço de autenticação retorna um objeto Usuario
            Object usuario = authService.getAuthenticatedUser(email);

            // Armazena o usuário no modelo para a sessão
            model.addAttribute("usuario", usuario);

            // Redireciona para a página de perfil após login bem-sucedido
            return "redirect:/profile";
        } else {
            model.addAttribute("error", "Credenciais inválidas.");
            return "login/login"; // Retorna à página de login com erro
        }
    }
}
