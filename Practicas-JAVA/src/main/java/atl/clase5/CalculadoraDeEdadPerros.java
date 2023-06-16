package atl.clase5;

import java.util.Scanner;

public class CalculadoraDeEdadPerros{
    public static void main(String[] args) {

        // Con esto creamos un objecto Scanner para poner recibir el ingreso por teclado
        Scanner input = new Scanner(System.in);

        // Pido el ingreso por teclado al usuario
        System.out.print("Ingrese la edad en anios humanos para poder recibir su edad en anios perro: ");
        Integer edadEnAniosHumanos = input.nextInt();

        // Convierto la entrada a anios perros
        Integer edadEnAniosPerro = convertirEdadHumanaAedadPerros(edadEnAniosHumanos);

        // Imprimo la salida de la funcion mostrando la diferencia
        System.out.println("Su edad en anios humanos es " + edadEnAniosHumanos);
        System.out.println("Su edad en anois perros es: " + edadEnAniosPerro);
    }

    public static Integer convertirEdadHumanaAedadPerros(Integer edadEnAniosHumanos){
        Integer edadEnAniosPerros = edadEnAniosHumanos * 7;
        return edadEnAniosPerros;
    };

}