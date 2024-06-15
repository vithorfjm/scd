package br.com.queventu.scd.repositories;

import br.com.queventu.scd.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    List<Contrato> findByContratanteId(Long contratanteId);

    List<Contrato> findByContratadoId(Long contratadoId);
}
