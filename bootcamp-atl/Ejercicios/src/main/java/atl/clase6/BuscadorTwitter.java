package atl.clase6;

public class BuscadorTwitter{



    public static String buscadorTwitter(String nombre){
        String linkAlTwitter = "https://twitter.com/search?q=" + nombre;
        return linkAlTwitter;
    }

}