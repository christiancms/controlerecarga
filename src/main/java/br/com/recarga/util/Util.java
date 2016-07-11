/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.util;

/**
 *
 * @author christian
 */
public class Util {

    static final int DIVISOR = 11;

    static boolean isCpfCnpj(String cpfcnpj) {
        Boolean valido = false;
        String novoCpfCnpj;
        int dv1, dv2, soma = 0;
        if (!cpfcnpj.trim().isEmpty()) {
            cpfcnpj = cpfcnpj.replace(".", "").replace("-", "").replace("/", "");
            switch (cpfcnpj.length()) {

                case 11:
                    /**
                     * Percorre a String cpfcnpj da posição 0 até a 9 e a cada
                     * laço converte o caractér em Inteiro. Cada caractére é
                     * multiplicado pela sequência decrescente de Dez até Dois,
                     * acumulando o total para encontrar o resto da divisão por
                     * Onze. Caso esse resto seja subtraído de Onze for maior
                     * que Nove, o primeiro Dígito Verificador será Zero senão
                     * será a diferença.
                     */
                    int dez = 10;
                    for (int i = 0; i < cpfcnpj.length() - 2; i++) {
                        int z = Character.digit(cpfcnpj.charAt(i), 10);
                        soma = soma + (dez * z);
                        dez--;
                    }
                    dv1 = DIVISOR - (soma % DIVISOR);
                    dv1 = (dv1 > 9) ? 0 : dv1;
                    String cpfDv = cpfcnpj.substring(0, 9) + dv1;
                    int onze = DIVISOR;
                    soma = 0;
                    /**
                     * Percorre a String cpfDv com o primeiro dígito já
                     * encontrado da posição 0 até 10 e a cada laço converte o
                     * caractér em Inteiro. Cada caractére é multiplicado pela
                     * sequência decrescente de Onze até Dois, acumulando o
                     * total para encontrar o resto da divisão por Onze. Caso
                     * esse resto seja subtraído de Onze for maior que Nove, o
                     * primeiro Dígito Verificador será Zero senão será a
                     * diferença.
                     */
                    for (int i = 0; i < cpfDv.length(); i++) {
                        int z = Character.digit(cpfDv.charAt(i), 10);
                        soma = soma + (onze * z);
                        onze--;
                    }
                    dv2 = DIVISOR - (soma % DIVISOR);
                    dv2 = (dv2 > 9) ? 0 : dv2;
                    novoCpfCnpj = cpfDv + dv2;
                    valido = cpfcnpj.equals(novoCpfCnpj);
                    break;

                case 14:
                    /**
                     * Percorre a String cpfcnpj da posição 0 até a 3 e a cada
                     * laço converte o caractér em Inteiro. Cada caractére é
                     * multiplicado pela sequência decrescente de Cinco até
                     * Dois, acumulando o total.
                     */
                    int cinco = 5;
                    soma = 0;
                    for (int i = 0; i < cpfcnpj.length() - 10; i++) {
                        int x = Character.digit(cpfcnpj.charAt(i), 10);
                        soma += cinco * x;
                        cinco--;
                    }
                    /**
                     * Percorre a String cpfcnpj da posição 4 até a 11 e a cada
                     * laço converte o caractér em Inteiro. Cada caractére é
                     * multiplicado pela sequência decrescente de Nove até Dois,
                     * acumulando o total.
                     */
                    int nove = 9;
                    for (int i = 4; i < cpfcnpj.length() - 2; i++) {
                        int x = Character.digit(cpfcnpj.charAt(i), 10);
                        soma += nove * x;
                        nove--;
                    }
                    /**
                     * É definido o módulo de Soma dos primeiros 4 caractéres
                     * mais os proxímos 8 por Onze e obtém-se o primeiro Dígito
                     * Verificador se o resultado for maior ou igual a Dois
                     * senão será Zero.
                     */
                    int y = soma % DIVISOR;
                    dv1 = (y < 2) ? 0 : DIVISOR - y;
                    cpfDv = cpfcnpj.substring(0, 12) + dv1;
                    soma = 0;
                    int seis = 6;
                    for (int i = 0; i < cpfcnpj.length() - 9; i++) {
                        int x = Character.digit(cpfcnpj.charAt(i), 10);
                        soma += seis * x;
                        seis--;
                    }
                    /**
                     * O segundo DV.
                     */
                    nove = 9;
                    for (int i = 5; i < cpfDv.length(); i++) {
                        int x = Character.digit(cpfDv.charAt(i), 13);
                        soma += nove * x;
                        nove--;
                    }
                    int resto = soma % DIVISOR;
                    dv2 = resto < 2 ? 0 : DIVISOR - resto;
                    novoCpfCnpj = cpfDv + dv2;
                    valido = cpfcnpj.equals(novoCpfCnpj);
                    break;
                default:
                    return false;
            }

        }
        return valido;
    }

    public static boolean isNumeric(String texto) {
        try {
            int inteiro = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
