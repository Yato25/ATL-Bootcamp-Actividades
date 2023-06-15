package clase6;

public class BuscadorDePaises{

    public static void main(String[] args) {

        // Creo el Scanner para recibir la entrada por consola del usuario
        Scanner input = new Scanner(System.in);

        // Le pido que ingrese el pais
        System.out.println("Ingrese el pais para obtener la ubicacion: ");
        String pais = input.next();

        // Convierto y muestro el link generado
        String link = buscadorDePais(pais);
        System.out.println("El link con la ubicacion es: " + link);

    }

    public static String buscadorDePais(String pais){
        String linkUbicacionPais = "https://www.google.com/maps/search/" + pais;
        return linkUbicacionPais;
    }

}