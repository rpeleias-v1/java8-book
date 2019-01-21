package com.rodrigopeleias.java8book.capitulo2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = false;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void tornaModerador() {
        this.moderador = true;
    }
}
