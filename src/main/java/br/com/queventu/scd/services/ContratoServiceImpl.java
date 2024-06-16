package br.com.queventu.scd.services;

import br.com.queventu.scd.entities.Contrato;
import br.com.queventu.scd.entities.Usuario;
import br.com.queventu.scd.repositories.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoServiceImpl implements ContratoService {

    private ContratoRepository contratoRepository;

    public ContratoServiceImpl(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    @Override
    public List<Contrato> listarContratos() {
        return contratoRepository.findAll();
    }

    @Override
    public Contrato listarContratoPeloId(Long id) {
        Optional<Contrato> contratoOpt = contratoRepository.findById(id);
        return contratoOpt.orElse(null);
    }

    @Override
    public List<Contrato> listarContratosPeloIdContratante(Long idContratante) {
        return contratoRepository.findByContratanteId(idContratante);
    }

    @Override
    public List<Contrato> listarContratosPeloIdContratado(Long idContratado) {
        return contratoRepository.findByContratadoId(idContratado);
    }

    @Override
    public void salvarContrato(Contrato contrato) {
        contratoRepository.save(contrato);
    }


    @Override
    public void excluirContrato(Long id) {
        // adicionar código ...
    }
}
