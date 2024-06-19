package br.com.queventu.scd.services;

import br.com.queventu.scd.entities.Contrato;
import br.com.queventu.scd.entities.Documento;
import br.com.queventu.scd.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class DocumentoService {

    private final Path localRaiz = Paths.get("uploads");

    @Autowired
    private DocumentoRepository documentoRepository;

    public Documento armazenar(MultipartFile arquivo, Contrato contrato) throws IOException {
        String nomeArquivo = StringUtils.cleanPath(arquivo.getOriginalFilename());
        Path arquivoDestino = localRaiz.resolve(Paths.get(nomeArquivo)).normalize().toAbsolutePath();

        try (InputStream inputStream = arquivo.getInputStream()) {
            Files.copy(inputStream, arquivoDestino, StandardCopyOption.REPLACE_EXISTING);
        }

        Documento documento = new Documento();
        documento.setNomeArquivo(nomeArquivo);
        documento.setCaminhoArquivo(localRaiz.resolve(nomeArquivo).toString());
        documento.setContrato(contrato);
        System.out.println("Documento salvo: " + documento.getCaminhoArquivo());
        return documentoRepository.save(documento);
    }

    public Resource carregarComoRecurso(String nomeArquivo) {
        try {
            Path arquivo = localRaiz.resolve(nomeArquivo);
            Resource resource = new UrlResource(arquivo.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Não foi possível ler o arquivo: " + nomeArquivo);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Não foi possível ler o arquivo: " + nomeArquivo, e);
        }
    }
}
