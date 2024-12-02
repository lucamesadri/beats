package br.edu.univille.beats.service;

import br.edu.univille.beats.entity.Usuario;
import br.edu.univille.beats.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean authenticate(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        return usuario != null && usuario.getSenha().equals(senha);
    }

    public Usuario getAuthenticatedUser(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean register(String nome, String email, String senha) {
        Usuario usuarioExistente = usuarioRepository.findByEmail(email);
        if (usuarioExistente != null) {
            return false;
        }

        // Criação de um novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);

        // Salva o novo usuário no banco de dados
        usuarioRepository.save(novoUsuario);
        return true;
    }
}
