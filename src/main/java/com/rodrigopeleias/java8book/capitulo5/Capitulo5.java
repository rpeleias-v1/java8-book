package com.rodrigopeleias.java8book.capitulo5;

import com.rodrigopeleias.java8book.capitulo2.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Capitulo5 {

    public static void main(String[] args) {
        Usuario rodrigo = new Usuario("Rodrigo", 20);
        Usuario denise = new Usuario("Denise", 15);
        Usuario pandora = new Usuario("Pandora", 100);

        List<Usuario> usuarios = Arrays.asList(rodrigo, denise, pandora);

        // comparator com functional interface
        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        // uso da interface comparing
        Collections.sort(usuarios, Comparator.comparing(Usuario::getNome));

        //default method de sort
        usuarios.sort(Comparator.comparing(Usuario::getNome));

        // uso de comparingInt para evitar problemas de autoboxing
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
    }
}
