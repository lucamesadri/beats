package br.edu.univille.beats.service;

import br.edu.univille.beats.repositorio.UsuarioRepository;  // Corrigido para 'repository' ao invés de 'repositorio'
import br.edu.univille.beats.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;  // Injeção de dependência correta

    // Método de registro de usuário
    public boolean register(String nome, String email, String senha) {
        // Verifica se o email já existe no banco de dados
        if (usuarioRepository.findByEmail(email) != null) {
            return false; // O email já está registrado
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);  // A senha será salva em texto simples

        usuarioRepository.save(usuario);  // Salva o novo usuário no banco de dados
        return true;
    }

    // Método de autenticação
    public boolean authenticate(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);  // Corrigido para usar a injeção corretamente
        return usuario != null && usuario.getSenha().equals(senha);  // Compara a senha fornecida com a armazenada
    }
}
