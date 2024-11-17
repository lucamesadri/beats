package br.edu.univille.beats.controller;

import br.edu.univille.beats.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    // Exibe o formulário de login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login/login"; // Retorna o template de login na subpasta 'login'
    }

    // Processa o login do usuário
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        Model model) {
        boolean isAuthenticated = authService.authenticate(email, senha);

        if (isAuthenticated) {
            return "redirect:/home"; // Redireciona para a página inicial após login bem-sucedido
        } else {
            model.addAttribute("error", "Credenciais inválidas."); // Adiciona mensagem de erro
            return "login/login"; // Retorna à página de login com o erro
        }
    }

    // Exibe o formulário de registro
    @GetMapping("/register")
    public String showRegisterForm() {
        return "login/register"; // Retorna o template de registro na subpasta 'login'
    }

    // Processa o registro de novos usuários
    @PostMapping("/register")
    public String registerUser(@RequestParam String nome,
                               @RequestParam String email,
                               @RequestParam String senha,
                               @RequestParam String confirmarSenha,
                               Model model) {
        // Validação das senhas
        if (!senha.equals(confirmarSenha)) {
            model.addAttribute("error", "As senhas não conferem.");
            return "login/register"; // Retorna à página de registro com o erro
        }

        // Chama o serviço de registro
        boolean isRegistered = authService.register(nome, email, senha);

        if (isRegistered) {
            return "redirect:/login"; // Redireciona para a página de login após registro
        } else {
            model.addAttribute("error", "Erro ao registrar usuário. Tente novamente.");
            return "login/register"; // Retorna à página de registro com o erro
        }
    }

    // Redireciona para a página inicial (exemplo)
    @GetMapping("/home")
    public String home() {
        return "home"; // Altere para o template da página inicial
    }
}
