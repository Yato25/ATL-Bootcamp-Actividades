package Clase5;

import java.util.Scanner;

public class ConversorDeMillasAkilometros {

    public static void main(String[] args) {

        // Creo el objeto Scanner para pedir la entrada por teclado del usuario
        Scanner input = new Scanner(System.in);

        // Pido la entrada
        System.out.println("Ingrese la cantidad de millas a convertir a kilometros: ");
        Double millas = input.nextDouble();

        // Convierto y muestro
        Double kilometros = convertirMillasAkilometros(millas);
        System.out.println("La cantidad de millas " + millas + " es igual a " + kilometros + " kilometros");
    }

    public  static Double convertirMillasAkilometros(Double millas){
        Double millasAkilometros = millas * 1.60934;
        return millasAkilometros;
    }

}
