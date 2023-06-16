package atl.clase5;

import java.util.Scanner;

public class JuegoAdivinarElnumero {


    public static void main(String[] args) {
        // Aclaracion: Math.random() devuelve un valor entre [0,1.0)
        // es decir que es mayor o igual a cero y menor estricto que 1

        // Para que la trivia sea con un entero entre 1 y 100 hay que hacer un par de modificaciones
        // Math.random() * 100 --> esto devuelve un valor entre 0 -- 99.99
        // Math.random() * 100 + 1 --> esto devuelve un valor entre 0 -- 100.99
        // Lo bueno es que al castear a integer "(int)" la parte decimal del numero no esta
        // asi que (int) (Math.random() * 100 + 1) estaria funcionando.

        // Creo el numero aleatroio
        Integer numeroSecreto = (int) Math.random();

        // Creo el objeto Scanner para poder capturar entradas del teclado
        Scanner input = new Scanner(System.in);

        // Titulo
        System.out.println("Adivine el numero secreto");

        // Inicializo los intentos en 5
        Integer intentos = 5;

        // Creo el bucle while el cual sale cuando el usario adivina o falla 5 veces.
        while(intentos > 0){

            System.out.println("Ingrese un numero entre 1 -- 100: ");
            Integer numeroDelUsuario = input.nextInt();

            // Si el numero del usuario coincide con el numero secreto termino el ciclo
            // Sino ignora esta linea y sigue ciclando
            if (numeroDelUsuario == numeroSecreto) {
                break;
            }

            // Resto uno a la cantidad de intentos
            intentos--;
        }

        // Si los intentos son mayor a cero signica que gano e imprimo el mensaje a continuacion
        if(intentos > 0){
            System.out.println("FELICIDADES HAS GANADO EL NUMERO CORRECTO ERA: " + numeroSecreto);
        }
        // Si lo intentos son cero entonces imprimo el mensje de derrota
        else{
            System.out.println("LO SIENTO HAS PERDIDO EL NUMERO SECRETO ERA: " + numeroSecreto);
        }
    }
}
