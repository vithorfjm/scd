package br.com.queventu.scd.entities;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private Long id;

    @Column(name="nome_usuario")
    private String nome;

    @Column(name="papel_usuario")
    private PapelUsuario papelUsuario;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PapelUsuario getPapelUsuario() {
        return papelUsuario;
    }

    public void setPapelUsuario(PapelUsuario papelUsuario) {
        this.papelUsuario = papelUsuario;
    }
}
