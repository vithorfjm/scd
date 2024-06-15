package br.com.queventu.scd.services;


import br.com.queventu.scd.entities.Contrato;

import java.util.List;


public interface ContratoService {

    List<Contrato> listarContratos();

    List<Contrato> listarContratosPeloIdContratante(Long idContratante);

    List<Contrato> listarContratosPeloIdContratado(Long idContratado);

    void criarContrato(Contrato contrato);

    void alterarContrato(Contrato contrato);

    void excluirContrato(Long id);
}
