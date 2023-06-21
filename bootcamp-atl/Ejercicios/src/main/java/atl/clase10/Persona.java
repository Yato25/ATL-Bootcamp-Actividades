package atl.clase10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

public class Persona {
    private String id;
    private String nombre;
    private String DNI;
    private LocalDate fechaDeNacimiento; // Date

    public Persona(){
        id = "";
        nombre = "";
        DNI = "";
        fechaDeNacimiento = LocalDate.of(2023, Month.JANUARY, 1);
    }
    public Persona(String id, String nombre, String DNI, String fechaDeNacimiento){
        this.id = id;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento.toString() + '\'' +
                '}';
    }

    public void mostrar(){
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("ID: " + this.getId());
        System.out.println("DNI: " + this.getDNI());
        System.out.println("Fecha de nacimineto: " + this.getFechaDeNacimiento().toString());
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento){
        this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    public LocalDate getFechaDeNacimiento(){
        return fechaDeNacimiento;
    }

    public boolean esMayorDeEdad(){
        if(fechaDeNacimiento == null){
            return false;
        }
        LocalDateTime fechaActual = LocalDateTime.now();            // Obtengo la fecha actual
        long numeroDeDias = DAYS.between(this.fechaDeNacimiento, fechaActual);  // Obtengo la diferencia de dias entre la fecha de
                                                                    // nacimiento y la fecha actual
        boolean pasoLos18 = numeroDeDias / 365 >= 18;               // Si la cantidad de anios es mayor o igual a 18 pasa

        return pasoLos18;
    }

    public static void main(String[] args) {
        Persona persona = new Persona("1",
                "PEPE",
                "555555", "22-05-1990");

        persona.mostrar();
        System.out.println(persona.esMayorDeEdad());

        Persona persona2 = new Persona();

        persona2.mostrar();
    }
}
