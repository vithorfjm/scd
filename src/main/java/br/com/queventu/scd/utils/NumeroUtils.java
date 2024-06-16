package br.com.queventu.scd.utils;

import java.util.List;

public class NumeroUtils {

    public static Double valorMonetarioParaDouble(String valorMonetario) {
        if (valorMonetario == null || valorMonetario.isEmpty())
            return null;
        valorMonetario = valorMonetario.replaceAll("[^\\d.,]", "");
        valorMonetario = valorMonetario.replace(".", "");
        valorMonetario = valorMonetario.replace(",", ".");
        return Double.parseDouble(valorMonetario);
    }

}
