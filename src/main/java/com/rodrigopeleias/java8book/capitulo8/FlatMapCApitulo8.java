package com.rodrigopeleias.java8book.capitulo8;

import com.rodrigopeleias.java8book.capitulo2.Usuario;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapCApitulo8 {

    public static void main(String[] args) {
        Usuario rodrigo = new Usuario("Rodrigo", 20);
        Usuario denise = new Usuario("Denise", 15);
        Usuario pandora = new Usuario("Pandora", 100);

        Grupo englishSpeakers = new Grupo();
        englishSpeakers.add(rodrigo);
        englishSpeakers.add(denise);

        Grupo spanishSpeakers = new Grupo();
        spanishSpeakers.add(denise);
        spanishSpeakers.add(pandora);

        List<Grupo> grupos = Arrays.asList(englishSpeakers, spanishSpeakers);

        List<Usuario> usuarios = grupos.stream()
                .flatMap(g -> g.getUsuarios().stream())
                .distinct()
                .collect(Collectors.toList());

        usuarios.forEach(System.out::println);
    }
}

@Getter
class Grupo {
    private Set<Usuario> usuarios = new HashSet<>();

    public void add(Usuario u) {
        usuarios.add(u);
    }
}
