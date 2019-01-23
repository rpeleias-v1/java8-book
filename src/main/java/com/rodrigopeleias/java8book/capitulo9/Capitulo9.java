package com.rodrigopeleias.java8book.capitulo9;

import com.rodrigopeleias.java8book.capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Capitulo9 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);
        Usuario user4 = new Usuario("Sergio Lopes", 120);
        Usuario user5 = new Usuario("Adriano Almeida", 100);

        List<Usuario> usuarios =
                Arrays.asList(user1, user2, user3, user4, user5);

        Map<Integer, List<Usuario>> pontuacao = new HashMap<>();
        for (Usuario usuario: usuarios) {
            pontuacao.computeIfAbsent(usuario.getPontos(), user -> new ArrayList<>()).add(usuario);
        }
        System.out.println(pontuacao);

        Map<Integer, List<Usuario>> pontuacaoGrouped = usuarios.stream()
                .collect(Collectors.groupingBy(Usuario::getPontos));
        System.out.println(pontuacaoGrouped);

        Map<Boolean, List<String>> nomesPorTipo = usuarios.stream()
                .collect(Collectors.partitioningBy(
                        Usuario::isModerador,
                        Collectors.mapping(Usuario::getNome, Collectors.toList())
                ));
        System.out.println(nomesPorTipo);

        Map<Boolean, Integer> pontuacaoPorTipo = usuarios.stream()
                .collect(Collectors.partitioningBy(
                        Usuario::isModerador,
                        Collectors.summingInt(Usuario::getPontos))
                );
        System.out.println(pontuacaoPorTipo);

        String nomes = usuarios.stream()
                .map(Usuario::getNome)
                .collect(Collectors.joining(", "));
        System.out.println(nomes);
    }
    
}
