package br.com.queventu.scd.controllers;

import br.com.queventu.scd.entities.Contrato;
import br.com.queventu.scd.entities.PapelUsuario;
import br.com.queventu.scd.entities.Usuario;
import br.com.queventu.scd.services.ContratoService;
import br.com.queventu.scd.services.UsuarioService;
import br.com.queventu.scd.utils.NumeroUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/formCriacao")
    public String mostrarFormsCriacao(Model model) {
        Contrato contrato = new Contrato();
        List<Usuario> gestores = usuarioService.listarUsuariosPeloPapel(PapelUsuario.GESTOR);
        List<Usuario> clientes = usuarioService.listarUsuariosPeloPapel(PapelUsuario.CLIENTE);

        model.addAttribute("contrato", contrato);
        model.addAttribute("gestores", gestores);
        model.addAttribute("clientes", clientes);
        return "contratos/criar-contrato";
    }

    @PostMapping("/criar")
    public String criarContrato(@ModelAttribute("contrato") Contrato contrato,
                                HttpServletRequest req) {
        String valorFormatado = req.getParameter("valorFormatado");
        Usuario contratante = usuarioService.listarUsuarioPeloId(contrato.getContratante().getId());
        Usuario contratado = usuarioService.listarUsuarioPeloId(contrato.getContratado().getId());
        contrato.setValor(NumeroUtils.valorMonetarioParaDouble(valorFormatado));
        contrato.setContratante(contratante);
        contrato.setContratado(contratado);
        contrato.setDataCriacao(LocalDateTime.now());
        contrato.setDataUltimaAlteracao(LocalDateTime.now());
        contratoService.salvarContrato(contrato);
        return "redirect:/contratos/listar";
    }

    @GetMapping("/formEdicao/{id}")
    public String formEdicao(@PathVariable Long id, Model model) {
        Contrato contrato = contratoService.listarContratoPeloId(id);
        List<Usuario> gestores = usuarioService.listarUsuariosPeloPapel(PapelUsuario.GESTOR);
        List<Usuario> clientes = usuarioService.listarUsuariosPeloPapel(PapelUsuario.CLIENTE);
        model.addAttribute("contrato", contrato);
        model.addAttribute("gestores", gestores);
        model.addAttribute("clientes", clientes);
        return "contratos/editar-contrato";
    }

    @PostMapping("/editar")
    public String editarContrato(@ModelAttribute("contrato") Contrato contratoAtualizado,
                                 HttpServletRequest req) {
        Contrato contratoPreEdicao = contratoService.listarContratoPeloId(contratoAtualizado.getId());
        String valorFormatado = req.getParameter("valorFormatado");
        contratoAtualizado.setDataCriacao(contratoPreEdicao.getDataCriacao());
        contratoAtualizado.setContratante(contratoPreEdicao.getContratante());
        contratoAtualizado.setContratado(contratoPreEdicao.getContratado());
        contratoAtualizado.setValor(NumeroUtils.valorMonetarioParaDouble(valorFormatado));
        contratoAtualizado.setDataUltimaAlteracao(LocalDateTime.now());
        contratoService.salvarContrato(contratoAtualizado);
        return "redirect:/contratos/listar";
    }
}
