package com.rodrigopeleias.java8book.capitulo6;

import com.rodrigopeleias.java8book.capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class Capitulo6 {

    public static void main(String[] args) {
        Usuario rodrigo = new Usuario("Rodrigo", 20);
        Usuario denise = new Usuario("Denise", 15);
        Usuario pandora = new Usuario("Pandora", 100);

        List<Usuario> usuarios = Arrays.asList(rodrigo, denise, pandora);

        // method reference
        Consumer<Usuario> tornaModerador = Usuario::tornaModerador;
        usuarios.forEach(tornaModerador);

        Function<Usuario, String> byName = Usuario::getNome;
        usuarios.sort(comparing(byName));

        usuarios.sort(comparingInt(Usuario::getPontos));

        // composição de Comparators
        usuarios.sort(comparing(byName).thenComparingInt(Usuario::getPontos));

        // comparator reversed
        usuarios.sort(comparing(byName).reversed());

        usuarios.forEach(System.out::println);

        //referenciando construtores default
        Supplier<Usuario> criadorDeUsuarios = Usuario::new;
        Usuario usuario = criadorDeUsuarios.get();

        BiFunction<String, Integer, Usuario> criadorDeUsuarioComParametro = Usuario::new;
        Usuario rodrigoNew = criadorDeUsuarioComParametro.apply("Rodrigo", 100);
    }
}
