package atl.clase10;

import java.math.BigDecimal;

public class Cuenta {

    private Persona titular;
    private BigDecimal dinero;

    public Cuenta(){}

    public Cuenta(Persona titular, Double dinero){
        this.titular = titular;
        this.dinero = new BigDecimal(dinero);
    }

    // Si no hay setters se vuelve inmutable
    // No se puede modificar los atributos de instancia
    public Persona getTitular(){
        return titular;
    }

    public BigDecimal getDinero(){
        return this.dinero;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "titular=" + titular +
                ", dinero=" + dinero +
                '}';
    }

    public void mostrar(){
        System.out.println(this.toString());
    }

    public void ingresar(Double cantidad){
        if(cantidad < 0){
            return;
        }
        this.dinero = this.dinero.add(new BigDecimal(cantidad));
    }

    public BigDecimal retirar(Double cantidad){
        if(this.dinero.doubleValue() < cantidad){
            throw new IllegalArgumentException("FLACO NO TENE ESA PLATA SALI DE ACA.");
        }
        // Puede quedar en numeros ROJOS
        this.dinero = this.dinero.subtract(new BigDecimal(cantidad));
        return new BigDecimal(cantidad);
    }

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        Cuenta cuenta2 = new Cuenta(new Persona("1", "Jorge", "4233889", "20-06-2001"), 20000.0);
        cuenta.mostrar();
        cuenta2.mostrar();

        cuenta2.retirar(400000.0);
    }
}
