package com.rodrigopeleias.java8book.capitulo4;

import com.rodrigopeleias.java8book.capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo4 {

    public static void main(String[] args) {
        Usuario rodrigo = new Usuario("Rodrigo", 20);
        Usuario denise = new Usuario("Denise", 15);
        Usuario pandora = new Usuario("Pandora", 180);

        List<Usuario> usuarios = new ArrayList<>(Arrays.asList(rodrigo, denise, pandora));

        Consumer<Usuario> mostraMensagem = u -> System.out.println("antes de imprimir os nomes");

        Consumer<Usuario> imprimeNomes = u -> System.out.println(u.getNome());

        // uso do default method andThen
        mostraMensagem.andThen(imprimeNomes);

        // uso do default method removeIf
        usuarios.removeIf(u -> u.getPontos() > 100);
        usuarios.forEach(System.out::println);
    }
}
