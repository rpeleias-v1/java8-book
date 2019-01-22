package com.rodrigopeleias.java8book.capitulo7;

import com.rodrigopeleias.java8book.capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Capitulo7 {

    public static void main(String[] args) {
        Usuario rodrigo = new Usuario("Rodrigo", 20);
        Usuario denise = new Usuario("Denise", 15);
        Usuario pandora = new Usuario("Pandora", 100);

        List<Usuario> usuarios = Arrays.asList(rodrigo, denise, pandora);

        usuarios.stream()
                .filter(u -> u.getPontos() > 50)
                .forEach(System.out::println);

        List<Usuario> usuariosFiltrados = usuarios.stream()
                .filter(u -> u.getPontos() > 50)
                .collect(Collectors.toList());
        usuariosFiltrados.forEach(System.out::println);

        // somente listagem de pontos
        List<Integer> pontos = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .boxed().collect(Collectors.toList());
        pontos.forEach(System.out::println);

        double averageValue = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .orElse(0.0);
        System.out.println(averageValue)

        double averageValueWithException = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .orElseThrow(IllegalStateException::new);
        System.out.println(averageValueWithException);
    }
}
