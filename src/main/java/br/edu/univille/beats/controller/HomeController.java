package br.edu.univille.beats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Define a rota para a página inicial
    public String home() {
        return "main/index"; // Retorna o arquivo index.html da pasta templates
    }
}
