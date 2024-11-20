package br.edu.univille.beats.service;

import br.edu.univille.beats.entity.Usuario;
import br.edu.univille.beats.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Injeção do repositório para acesso ao banco de dados
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
}
