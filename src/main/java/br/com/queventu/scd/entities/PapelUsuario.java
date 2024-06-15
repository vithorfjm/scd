package br.com.queventu.scd.entities;

public enum PapelUsuario {
    CLIENTE("CLIENTE"),
    GESTOR("GESTOR"),
    ADMINISTRADOR("ADMINISTRADOR");

    private final String papel;

    PapelUsuario(String papel) {
        this.papel = papel;
    }

    public String getPapel() {
        return papel;
    }
}
