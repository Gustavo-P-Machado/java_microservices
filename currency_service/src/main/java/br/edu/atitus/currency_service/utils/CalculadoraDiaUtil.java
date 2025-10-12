package br.edu.atitus.currency_service.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalculadoraDiaUtil {

    //Isso me custou algumas horas de sono, eu espero que dê certo em outras máquinas :D

    public static LocalDate getDiaUtil (LocalDate data) {
        return switch (data.getDayOfWeek()) {
            case SATURDAY -> data.minusDays(1);
            case SUNDAY -> data.minusDays(2);
            default -> data;
        };
    }

    private static final DateTimeFormatter ajustarData = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public static String formatarData(LocalDate data) {
        return data.format(ajustarData);
    }

}
