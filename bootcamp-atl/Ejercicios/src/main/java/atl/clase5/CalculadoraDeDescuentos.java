package atl.clase5;

import java.util.Scanner;

public class CalculadoraDeDescuentos {

    public static void main(String[] args) {

        // Creo el objeto para que el usuario pueda ingresar por teclado el precio y el descuento
        Scanner input = new Scanner(System.in);

        // Pido el precio
        System.out.print("Ingrese el precio original: " );
        Double precioOriginal = input.nextDouble();

        // Pido el descuento
        System.out.print("Ingrese el descuento para aplicar al precio original: ");
        Double descuento = input.nextDouble();

        // Hago el calculo y se lo muestro por pantalla
        Double precioConDescuento = calcularDescuento(precioOriginal, descuento);
        System.out.println("El precio original es: " + precioOriginal);
        System.out.println("El descuento a aplicar es: " + descuento);
        System.out.println("El precio final aplicando el descuento es: " + precioConDescuento);
    }


    public static Double calcularDescuento(Double precioOrigianl, Double descuento){
        Double precioConDescuento = precioOrigianl - (precioOrigianl * descuento / 100);

        return precioConDescuento;
    }
}
