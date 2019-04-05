package taller2;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JAVIER
 */
public class Taller2 {

    public static void main(String[] args) {

    }

// transforma un numero decimal a su representacion floante
    public static String decToFloat(int decimal) {
        String flotante;
        flotante = binToFloat(parseBin(decimal));
        if (decimal >= 0) {
            flotante = "0" + flotante;
        } else {
            flotante = "1" + flotante;
        }

        return flotante;

    }

    //representacion del float de un numero en binario sin el signo
    public static String binToFloat(String bin) {
        String Float;

        String expF = exp(bin.length() - 1);
        String mantisa = bin.substring(1, bin.length());

        if (mantisa.length() < 10) {
            while (mantisa.length() < 10) {
                mantisa = mantisa + "0";
            }
        } else if (mantisa.length() > 10) {

            while (mantisa.length() > 10) {
                int i = 1;
                mantisa = mantisa.substring(0, mantisa.length() - i);
            }

        }

        Float = expF + mantisa;

        return Float;
    }

    //devuelve la representacion binaria del exponente
    public static String exp(int exp) {
        int cambio = exp + 15;
        String expF = parseBin(cambio);

        return expF;
    }

    //devuelve representacion binaria de un decimal
    public static String parseBin(int dec) {

        dec = Math.abs(dec);
        int resto;
        String transformada = "";
        while (dec > 0) {
            resto = dec % 2;
            //System.out.println(dec);
            dec = dec / 2;

            transformada = resto + transformada;

        }

        return transformada;

    }

    //devuelve la representacion decimal de un flotante
    public static double floatToDec(String flotante) {

        double decimal = mantissa(flotante);
        if ("1".equals("" + flotante.charAt(0))) {
            decimal = decimal * -1;

        }

        return (decimal);
    }

    //devuelve la representacion decimal de los bits del exponente
    public static int expFloat(String exp) {
        int numero = parseInt(exp);
        numero = numero - 15;
        return numero;

    }

    //calcula el valor en decimal de los bits de la mantisa
    public static int mantissa(String mantissa) {
        int mantisa = 0;
        int exponente = expFloat(mantissa.substring(1, 6));
        if (exponente > 10) {
            int aux = exponente - 10;
            exponente = 10;
            String cambiar = mantissa.substring(6, exponente + 6);
            cambiar = "1" + cambiar;
            for (int i = 0; i < aux; i++) {
                cambiar = cambiar + "0";
            }
            System.out.print(cambiar);
            mantisa = parseInt(cambiar);

        } else if (exponente <= 10) {
            String cambiar = mantissa.substring(6, exponente + 6);
            cambiar = "1" + cambiar;
            mantisa = parseInt(cambiar);

        }
        return mantisa;
    }

    //entrega el valor decimal de un numero binario
    public static int parseInt(String bin) {
        int decimal = 0;
        int largo = bin.length();

        for (int i = 0; i < largo; i++) {
            char variable = bin.charAt(largo - i - 1);

            int entero = Integer.parseInt("" + variable);
            decimal = (int) (decimal + (entero * pow((double) 2, (double) i)));

        }
        return decimal;
    }

}
