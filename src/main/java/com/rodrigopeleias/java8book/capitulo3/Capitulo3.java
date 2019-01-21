package com.rodrigopeleias.java8book.capitulo3;

public class Capitulo3 {

    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        };
        new Thread(r).start();

        // own functional interface usage
        Validator<String> validator = valor -> valor.matches("Rodrigo");
        System.out.println(validator.valida("Eu sou o Rodrigo"));

        int numero = 5;
        new Thread(() -> System.out.println(numero));
    }
}
