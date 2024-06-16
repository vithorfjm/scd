package br.com.queventu.scd.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Contrato {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="valor")
    private Double valor;

    @Column(name="descricao")
    private String descricao;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name="data_ultima_alteracao")
    private LocalDateTime dataUltimaAlteracao;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="contratante_id")
    private Usuario contratante;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="contratado_id")
    private Usuario contratado;

    public Contrato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Usuario getContratante() {
        return contratante;
    }

    public void setContratante(Usuario contratante) {
        this.contratante = contratante;
    }

    public Usuario getContratado() {
        return contratado;
    }

    public void setContratado(Usuario contratado) {
        this.contratado = contratado;
    }
}
