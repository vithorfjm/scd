package br.com.queventu.scd.services;


import br.com.queventu.scd.entities.Contrato;

import java.util.List;


public interface ContratoService {

    List<Contrato> listarContratos();

    Contrato listarContratoPeloId(Long id);

    List<Contrato> listarContratosPeloIdContratante(Long idContratante);

    List<Contrato> listarContratosPeloIdContratado(Long idContratado);

    void salvarContrato(Contrato contrato);

    void excluirContrato(Long id);
}
