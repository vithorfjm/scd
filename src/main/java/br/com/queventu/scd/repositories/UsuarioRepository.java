package br.com.queventu.scd.repositories;

import br.com.queventu.scd.entities.PapelUsuario;
import br.com.queventu.scd.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByPapelUsuario(PapelUsuario papelUsuario);

}
