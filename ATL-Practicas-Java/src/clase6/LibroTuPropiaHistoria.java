package clase6;

public class LibroTuPropiaHistoria{

    public static void main(String[] args) {

        String primeraEscena;
        String segundaEscena;
        String terceraEscena;

        primeraEscena = "Es una noche estrellada, te encuentras en un bosque misterioso:\n " +
                "1) Exploras la oscuridad en busca de la fuente de un susurro escalofriante\n" +
                "2) Sigues el sendero iluminado hacia una pequeña cabaña acogedora";


        // Primera parte
        System.out.println(primeraEscena);

        // Primera eleccion
        Integer eleccion = eleccion();

        if(eleccion == 1){

            segundaEscena = "Un inquietante ruido se mese a lo largo del bosque, empiezas a creer que quiza fue mala idea venir por el camino pero\n"
                    + "cuando miras hacia atras una espesa niebla evita que encuentres el camino de regreso. Ansioso empiezas a:\n"
                    + "1) Caminar mas deprisa \n" +
                    + "2) Buscar huellas de tus pisadas\n";

            System.out.println(segundaEscena);

            eleccion = eleccion();

            if(eleccion == 1){

                terceraEscena = "La oscuridad empieza a tornarse mas y mas densa.. oscura.. siniestra.. !De repente¡\n"
                        + "algo te ataca desde las sombras con sus garras y desgarra tu estomago.. a punto de morir de la nada...\n"
                        + "sientes tu cabeza mareada... te has despertado en tu casa.. y tu hermana te pregunta si estas bien\n"
                        + "se te ve palido como si vieras un fantasma. Tu hermana menor te abraza y te dice que solo fue una pesadilla...\n" +
                        + "pero se sintio tan real que no piensas de esa forma...";

                System.out.println(terceraEscena);

            }else{

                terceraEscena = "Empiezas a buscar alguna señal que te indique por que camino has venido, pero es inutil... \n"
                        +"solo encuentras hojas cubiertas con el rocio de la madrugada, de la nada ves una luz radiante como un faro\n"
                        + "\"Joven que hace por esta zona es un lugar inexplorado venga rapido, menos mal que lo encontramos patrullando la zona\"\n"
                        + "Decides seguirlos y aliviado sales de aquel bosque a salvo...";

                System.out.println(terceraEscena);
            }



        }else{

            segundaEscena = "Decides seguir el sendero iluminado hacia la pequeña cabaña acogedora. Al llegar a la cabaña, te das cuenta de que hay dos puertas: \n" +
                    "1) Entras por la puerta de la izquierda \n" +
                    "2) Optas por la puerta de la derecha\n";

            eleccion = eleccion();

            if(eleccion == 1){
                    terceraEscena = "Al abrir la puerta de la izquierda, te encuentras con una habitación llena de tesoros brillantes y mágicos. " +
                        "Te maravillas con las joyas y los objetos preciosos que llenan la sala. Te das cuenta de que has encontrado el legendario " +
                        "tesoro perdido del bosque. Con tu corazón lleno de emoción y riquezas, decides regresar a casa para compartir tu increíble" +
                        " aventura con el mundo. ¡Felicidades, has tenido un final exitoso en tu búsqueda!";

                    eleccion = eleccion();

            }else{

                    terceraEscena = "Al abrir la puerta de la derecha, te encuentras con un cartel que dice \"\"";


            }

        }


    }

    public static Integer eleccion(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la eleccion: ");
        Integer eleccion = input.nextInt();
        return eleccion;
    }
}