package Clase5;

import java.util.Scanner;

public class CalculadoraDePropinas {

    public static void main(String[] args) {

        // Creo el objeto Scanner para que le usuario pueda ingresar los valores por teclado
        Scanner input = new Scanner(System.in);

        // Pido que ingrese la cuenta total de un restaurante
        System.out.print("Ingrese la cuenta total de el restaurante: $");
        Double cuentaTotalRestaurante = input.nextDouble();

        // Pido que ingrese el porcentaje de propina que quiera dejar
        System.out.print("Ingrese el porcentaje de propina que desea dejar al mesero: ");
        Double porcentajePropina = input.nextDouble();

        // Calculo la propina
        Double propina = calcularPropina(cuentaTotalRestaurante, porcentajePropina);
        System.out.println("La propina a dejar es: $" + propina);
    }

    public static Double calcularPropina(Double totalCuenta, Double porcentajePropina){
        Double propina = totalCuenta * (porcentajePropina/100);
        return propina;
    }
}
