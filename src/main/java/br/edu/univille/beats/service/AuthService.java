package br.edu.univille.beats.service;

import br.edu.univille.beats.entity.Usuario;
import br.edu.univille.beats.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    // Este método valida o login verificando as credenciais
    public boolean authenticate(String email, String senha) {
        // Busca o usuário no banco de dados pelo email
        Usuario usuario = usuarioRepository.findByEmail(email);

        // Verifica se o usuário existe e se a senha está correta
        return usuario != null && usuario.getSenha().equals(senha);
    }

    // Este método retorna o usuário autenticado com base no e-mail
    public Usuario getAuthenticatedUser(String email) {
        // Busca o usuário no banco de dados pelo email
        return usuarioRepository.findByEmail(email);
    }

    // Este método registra um novo usuário
    public boolean register(String nome, String email, String senha) {
        // Verifica se o email já está registrado
        Usuario usuarioExistente = usuarioRepository.findByEmail(email);
        if (usuarioExistente != null) {
            return false; // O email já está em uso, não pode registrar
        }

        // Criação de um novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha); // Lembre-se de criptografar a senha em um ambiente real!

        // Salva o novo usuário no banco de dados
        usuarioRepository.save(novoUsuario);
        return true; // Retorna true indicando que o usuário foi registrado com sucesso
    }
}
