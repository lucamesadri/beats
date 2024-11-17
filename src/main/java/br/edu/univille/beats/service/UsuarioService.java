package br.edu.univille.beats.service;
import br.edu.univille.beats.entity.Usuario;
import br.edu.univille.beats.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void register(Usuario usuario) throws Exception {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new Exception("E-mail já registrado!");
        }
        usuarioRepository.save(usuario);
    }

    public Usuario authenticate(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }
}