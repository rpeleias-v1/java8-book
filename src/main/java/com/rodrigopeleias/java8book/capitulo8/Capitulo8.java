package com.rodrigopeleias.java8book.capitulo8;

import com.rodrigopeleias.java8book.capitulo2.Usuario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Capitulo8 {

    public static void main(String[] args) throws IOException {
        Usuario rodrigo = new Usuario("Rodrigo", 20);
        Usuario denise = new Usuario("Denise", 15);
        Usuario pandora = new Usuario("Pandora", 100);

        List<Usuario> usuarios = Arrays.asList(rodrigo, denise, pandora);

        usuarios.sort(Comparator.comparing(Usuario::getNome));

        Optional<Usuario> first = usuarios.stream()
                .filter(u -> u.getPontos() > 10)
                .sorted(Comparator.comparing(Usuario::getNome))
                .peek(System.out::println).findFirst();

        if (first.isPresent()) {
            System.out.println(first.get());
        }

        Optional<Usuario> optAnyUser = usuarios.stream()
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
        Random random = new Random(0);
        IntStream stream = IntStream.generate(() -> random.nextInt());


        List<Integer> pontos = stream
                .limit(100)
                .boxed().collect(Collectors.toList());
        pontos.forEach(System.out::println);

        // Praticando com Files NIO
        Files.list(Paths.get("."))
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(System.out::println);

        // Fibonacci com supplier
        IntStream.generate(new Fibonacci())
                .limit(10)
                .forEach(System.out::println);

        int maiorQue100 = IntStream.generate(new Fibonacci())
                .filter(f -> f > 100)
                .findFirst()
                .getAsInt();

        System.out.println(maiorQue100);
    }
}

class Fibonacci implements IntSupplier {

    private int anterior = 0;
    private int proximo = 1;

    @Override
    public int getAsInt() {
        proximo = proximo + anterior;
        anterior = proximo - anterior;
        return anterior;
    }
}
