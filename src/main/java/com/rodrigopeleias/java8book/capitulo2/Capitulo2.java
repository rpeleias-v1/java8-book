package com.rodrigopeleias.java8book.capitulo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {

    public static void main(String[] args) {
        Usuario rodrigo = new Usuario("Rodrigo", 20);
        Usuario denise = new Usuario("Denise", 15);
        Usuario pandora = new Usuario("Pandora", 100);

        List<Usuario> usuarios = Arrays.asList(rodrigo, denise, pandora);

        // forma 1 de fazer com java 8
        usuarios.forEach(new Consumer<Usuario>() {
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        });

        // forEach com lambda
        usuarios.forEach(usuario -> System.out.println(usuario.getNome()));

        // method reference - println - método ToString por default
        usuarios.forEach(System.out::println);

        usuarios.forEach(Usuario::tornaModerador);
    }
}
