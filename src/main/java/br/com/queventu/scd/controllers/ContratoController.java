package br.com.queventu.scd.controllers;

import br.com.queventu.scd.entities.Contrato;
import br.com.queventu.scd.services.ContratoService;
import br.com.queventu.scd.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contratos")
public class ContratoController {

    private ContratoService contratoService;

    private UsuarioService usuarioService;

    public ContratoController(ContratoService contratoService, UsuarioService usuarioService ) {
        this.contratoService = contratoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public String listarContratos(Model model) {
        List<Contrato> contratos = contratoService.listarContratos();
        model.addAttribute("contratos", contratos);
        return "contratos/lista-contratos";
    }

    @GetMapping("/criar")
    public String mostrarFormsCriacao(Model model) {
        Contrato contrato = new Contrato();
        model.addAttribute("contrato", contrato);
        return "contratos/criar-contrato";
    }

}
