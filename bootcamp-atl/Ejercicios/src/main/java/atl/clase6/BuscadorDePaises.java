package atl.clase6;

public class BuscadorDePaises{


    public static String buscadorDePais(String pais){
        String linkUbicacionPais = "https://www.google.com/maps/search/" + pais;
        return linkUbicacionPais;
    }

}