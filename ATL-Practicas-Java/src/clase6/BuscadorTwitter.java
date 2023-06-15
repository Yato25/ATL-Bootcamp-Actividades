package clase6;

public class BuscadorTwitter{

    public static void main(String[] args) {

        // Creamos el objeto Scanner para pedir la entrada del usuario
        Scanner input = new Scanner(System.in);

        // Pido que ingrese el nombre de alguna celebridad o conocidos
        System.out.println("Ingrese el nombre de alguna celebridad o influencer: ");
        String nombre = input.next();

        // Creo el link y se lo muestro
        String link = buscadorTwitter(nombre);
        System.out.println("El link generado es: " + link);

    }


    public static String buscadorTwitter(String nombre){
        String linkAlTwitter = "https://twitter.com/search?q=" + nombre;
        return linkAlTwitter;
    }

}