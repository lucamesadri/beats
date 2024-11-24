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
@SessionAttributes("usuario")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login/login"; // Retorna o template de login
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        Model model) {
        boolean isAuthenticated = authService.authenticate(email, senha);

        if (isAuthenticated) {
            Object usuario = authService.getAuthenticatedUser(email);
            model.addAttribute("usuario", usuario);
            return "redirect:/profile"; // Redireciona para o perfil após login
        } else {
            model.addAttribute("error", "Credenciais inválidas.");
            return "login/login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "login/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String nome,
                               @RequestParam String email,
                               @RequestParam String senha,
                               @RequestParam String confirmarSenha,
                               Model model) {
        if (!senha.equals(confirmarSenha)) {
            model.addAttribute("error", "As senhas não conferem.");
            return "login/register";
        }

        boolean isRegistered = authService.register(nome, email, senha);

        if (isRegistered) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Erro ao registrar usuário. Tente novamente.");
            return "login/register";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Página inicial
    }
}
