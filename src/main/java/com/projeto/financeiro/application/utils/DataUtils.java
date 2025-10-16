package com.projeto.financeiro.application.utils;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-yyyy");

    /**
     * Retorna o mês anterior no formato MM-yyyy
     * @param mesAno string no formato "MM-yyyy"
     * @return string com o mês anterior no mesmo formato
     */
    public static String getMesAnterior(String mesAno) {
        YearMonth ym = YearMonth.parse(mesAno, FORMATTER);
        return ym.minusMonths(1).format(FORMATTER);
    }

    /**
     * Retorna o próximo mês no formato MM-yyyy
     * @param mesAno string no formato "MM-yyyy"
     * @return string com o próximo mês no mesmo formato
     */
    public static String getProximoMes(String mesAno) {
        YearMonth ym = YearMonth.parse(mesAno, FORMATTER);
        return ym.plusMonths(1).format(FORMATTER);
    }
}
