package br.com.queventu.scd.services;

import br.com.queventu.scd.entities.Contrato;
import br.com.queventu.scd.entities.PapelUsuario;
import br.com.queventu.scd.entities.Usuario;
import br.com.queventu.scd.repositories.ContratoRepository;
import br.com.queventu.scd.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsuarioService {

    List<Usuario> listarUsuarios();

    List<Usuario> listarUsuariosPeloPapel(PapelUsuario papel);

    Usuario listarUsuarioPeloId(Long id);

    void criarUsuario(Usuario usuario);

    void alterarUsuario(Usuario usuario);

    void excluirUsuario(Long id);
}
