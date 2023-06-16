package atl.ejercicios;

import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {

    public static void main(String[] args) {
        PiedraPapelTijera juego = new PiedraPapelTijera();
        juego.comenzarJuego();
    }


    public enum OPCIONES{
        PIEDRA, PAPEL, TIJERAS
    }

    public enum RESULTADOS{
        GANO,EMPATO,PERDIO
    }

    Jugador jugador;
    Jugador maquina;
    Integer vidas;
    Integer puntaje;

    public PiedraPapelTijera(){
        jugador = new Jugador( "pepe");
        maquina = new Jugador("maquina");
        vidas = 3;
        puntaje = 0;
    }

    public void comenzarJuego(){
        mostrarEstado();
        while (vidas > 0){
            cargarEleccionJugador();
            cargarEleccionMaquina();
            mostrarElecciones();
            compararElecciones();
            mostrarEstado();
        }

        System.out.println("Tu puntaje final es: " + puntaje);
    }

    private void mostrarElecciones() {
        System.out.println(jugador.getNombre() + " ha elegido " + jugador.getOpcion());
        System.out.println(maquina.getNombre() + " ha elegido " + maquina.getOpcion());
    }

    private void mostrarEstado() {
        System.out.println("VIDAS: " + vidas);
        System.out.println("PUNTAJE: " + puntaje);
    }

    private void compararElecciones() {
        boolean gano = true;

        if (jugador.getOpcion().equals(maquina.getOpcion())){
            System.out.println("HAS EMPATADO");
            return;
        }else {
            if (jugador.getOpcion() == OPCIONES.PIEDRA){
                gano = maquina.getOpcion() == OPCIONES.TIJERAS;
            }

            if (jugador.getOpcion() == OPCIONES.TIJERAS){
                gano = maquina.getOpcion() == OPCIONES.PAPEL;
            }

            if (jugador.getOpcion() == OPCIONES.PAPEL){
                gano = maquina.getOpcion() == OPCIONES.PIEDRA;
            }

        }


        if (gano){
            System.out.println("HAS GANADO");
            puntaje++;
        }else{
            System.out.println("HAS PERDIDO");
            vidas--;
        }

    }

    public void cargarEleccionJugador(){
        System.out.println("Elija su eleccion: ");
        System.out.println("1-Piedra");
        System.out.println("2-Papel");
        System.out.println("3-Tijeras");

        Scanner input = new Scanner(System.in);
        Integer eleccion = input.nextInt();
        jugador.cargarEleccion(obtenerEleccion(eleccion));
    }

    public void cargarEleccionMaquina(){
        Random random = new Random();
        Integer eleccionMaquina = random.nextInt(1,4) ;
        maquina.cargarEleccion(obtenerEleccion(eleccionMaquina));
    }

    public OPCIONES obtenerEleccion(Integer eleccion){
        switch (eleccion){
            case 1:{
                return OPCIONES.PIEDRA;
            }
            case 2:{
                return OPCIONES.TIJERAS;
            }
            case 3:{
                return OPCIONES.PAPEL;
            }
            default:{
                return null;
            }
        }
    }


    private class Jugador{

        String nombre;
        OPCIONES eleccion;
        public Jugador(String _nombre){
            nombre = _nombre;
        }

        public String getNombre(){
            return nombre;
        }
        public void cargarEleccion(OPCIONES _eleccion){
            eleccion = _eleccion;
        }
        public OPCIONES getOpcion(){
            return eleccion;
        }
    }




}
