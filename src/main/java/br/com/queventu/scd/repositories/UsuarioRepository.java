package br.com.queventu.scd.repositories;

import br.com.queventu.scd.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
