package com.rodrigopeleias.java8book.capitulo8;

import com.rodrigopeleias.java8book.capitulo2.Usuario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Capitulo8 {

    public static void main(String[] args) throws IOException {
        Usuario rodrigo = new Usuario("Rodrigo", 20);
        Usuario denise = new Usuario("Denise", 15);
        Usuario pandora = new Usuario("Pandora", 100);

        List<Usuario> usuarios = Arrays.asList(rodrigo, denise, pandora);

        Optional<Usuario> first = usuarios.stream()
                .filter(u -> u.getPontos() > 50)
                .peek(System.out::println)
                .findFirst();

        if (first.isPresent()) {
            System.out.println(first.get());
        }

        usuarios.stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .peek(System.out::println)
                .findAny();

        // operaçoes de redução
        double average = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();
        System.out.println(average);

        int total = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .sum();
        System.out.println(total);

        int reducedMultiplier = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(1, (a, b) -> a * b);
        System.out.println(reducedMultiplier);

        //trabalhando com iterators
        usuarios.stream().iterator()
                .forEachRemaining(System.out::println);

        // testando predicates
        boolean matched = usuarios.stream().anyMatch(Usuario::isModerador);
        System.out.println(matched);

        // operações de curto circuito
        List<Integer> pontos = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .limit(100)
                .boxed().collect(Collectors.toList());
        pontos.forEach(System.out::println);

        // Praticando com Files NIO
        Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(System.out::println);
    }
}
