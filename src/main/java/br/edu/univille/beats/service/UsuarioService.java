package br.edu.univille.beats.service;

import br.edu.univille.beats.entity.Usuario;
import br.edu.univille.beats.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Autentica o usuário verificando email e senha
    public Usuario authenticate(String email, String senha) {
        // Busca o usuário pelo email
        Usuario usuario = usuarioRepository.findByEmail(email);

        // Verifica se o usuário existe e se a senha está correta
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario; // Retorna o usuário autenticado
        }

        return null; // Caso contrário, retorna null
    }

    // Método para buscar um usuário por ID
    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);  // Retorna o usuário ou null caso não encontrado
    }
}
