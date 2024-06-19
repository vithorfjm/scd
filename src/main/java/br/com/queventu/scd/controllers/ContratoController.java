package br.com.queventu.scd.controllers;

import br.com.queventu.scd.entities.Contrato;
import br.com.queventu.scd.entities.Documento;
import br.com.queventu.scd.entities.PapelUsuario;
import br.com.queventu.scd.entities.Usuario;
import br.com.queventu.scd.repositories.DocumentoRepository;
import br.com.queventu.scd.services.ContratoService;
import br.com.queventu.scd.services.DocumentoService;
import br.com.queventu.scd.services.UsuarioService;
import br.com.queventu.scd.utils.NumeroUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/contratos")
public class ContratoController {

    private final DocumentoRepository documentoRepository;
    private final DocumentoService documentoService;
    private ContratoService contratoService;

    private UsuarioService usuarioService;

    public ContratoController(ContratoService contratoService, UsuarioService usuarioService, DocumentoRepository documentoRepository, DocumentoService documentoService) {
        this.contratoService = contratoService;
        this.usuarioService = usuarioService;
        this.documentoRepository = documentoRepository;
        this.documentoService = documentoService;
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
                                HttpServletRequest req,
                                @RequestParam MultipartFile documento) {
        String valorFormatado = req.getParameter("valorFormatado");
        Usuario contratante = usuarioService.listarUsuarioPeloId(contrato.getContratante().getId());
        Usuario contratado = usuarioService.listarUsuarioPeloId(contrato.getContratado().getId());
        contrato.setValor(NumeroUtils.valorMonetarioParaDouble(valorFormatado));
        contrato.setContratante(contratante);
        contrato.setContratado(contratado);
        contrato.setDataCriacao(LocalDateTime.now());
        contrato.setDataUltimaAlteracao(LocalDateTime.now());
        contratoService.salvarContrato(contrato);
        try {
            documentoService.armazenar(documento, contrato);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @PostMapping("/excluir/{id}")
    public String excluirContrato(@PathVariable Long id) {
        contratoService.excluirContrato(id);
        return "redirect:/contratos/listar";
    }

    @GetMapping("/download/{id}")
    @ResponseBody
    public ResponseEntity<Resource> downloadDocumento(@PathVariable Long id) {
        Documento documento = documentoRepository.findByContratoId(id).orElseThrow(() -> new RuntimeException("Documento não encontrado"));
        Resource resource = documentoService.carregarComoRecurso(documento.getNomeArquivo());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documento.getNomeArquivo() + "\"")
                .body(resource);
    }
}
