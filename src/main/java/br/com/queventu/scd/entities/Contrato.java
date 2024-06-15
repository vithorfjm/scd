package br.com.queventu.scd.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Contrato {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="contrato_id")
    private int id;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name="data_ultima_alteracao")
    private LocalDateTime dataUltimaAlteracao;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="contratante_id")
    private Usuario contratante;

    @ManyToOne(cascade=CascadeType.ALL)
    private Usuario contratado;

}
