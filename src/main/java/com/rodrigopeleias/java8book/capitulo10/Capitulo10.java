package com.rodrigopeleias.java8book.capitulo10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Capitulo10 {

    public static void main(String[] args) {

        LocalDate mesQueVem = LocalDate.now().plusMonths(1);
        System.out.println(mesQueVem);
        LocalDate anoPassado = LocalDate.now().minusYears(1);
        System.out.println(anoPassado);

        System.out.println(LocalDateTime.now());

        System.out.println(LocalTime.now());

        // combinação cde LocalDate com LocalTime
        LocalTime agora = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEHora = hoje.atTime(agora);

        LocalDate date = LocalDate.of(2014, Month.DECEMBER, 25);
        LocalDateTime datetime = LocalDateTime.of(2014, 12, 25, 10, 30);

        // comparação de datas com is
        LocalDate amanha = LocalDate.now().plusDays(1);

        System.out.println(hoje.isBefore(amanha));
        System.out.println(hoje.isAfter(amanha));
        System.out.println(hoje.isEqual(amanha));

        LocalDateTime agoraFormatacao = LocalDateTime.now();
        System.out.println(agoraFormatacao.format(DateTimeFormatter.ISO_LOCAL_TIME));

//        LocalDate.of(2014, Month.FEBRUARY, 32);

        // Cálculo de datas com ChronoUnit
        LocalDate agora1 = LocalDate.now();
        LocalDate outraData = LocalDate.of(1988, Month.MARCH, 23);

        System.out.println(ChronoUnit.DAYS.between(outraData, agora1));
        System.out.println(ChronoUnit.MONTHS.between(outraData, agora1));
        System.out.println(ChronoUnit.YEARS.between(outraData, agora1));

        Period between = Period.between(outraData, agora1);
        System.out.println(between.getYears());


    }
}
