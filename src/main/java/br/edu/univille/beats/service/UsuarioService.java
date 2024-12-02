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

    public Usuario authenticate(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }

        return null;
    }
    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }
}
