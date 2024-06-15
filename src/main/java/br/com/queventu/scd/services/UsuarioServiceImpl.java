package br.com.queventu.scd.services;

import br.com.queventu.scd.entities.PapelUsuario;
import br.com.queventu.scd.entities.Usuario;
import br.com.queventu.scd.repositories.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> listarUsuariosPeloPapel(PapelUsuario papel) {
        try {
            return usuarioRepository.findByPapelUsuario(papel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Usuario listarUsuarioPeloId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    @Override
    public void criarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void alterarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
