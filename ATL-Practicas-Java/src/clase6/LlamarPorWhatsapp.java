package clase6;

public Class LlamarPorWhatsapp {

    public static void main(String[]args){

        // Creo el objeto Scanner para recibir la entrada del usuario por consola
        Scanner input = new Scanner(System.in);

        // Le pido el numero de telefo sin espacios al usuario
        System.out.println("Ingrese el numero de telefono sin espacios a continuacion: ");
        String numeroDeTelefono = input.next();

        // Hago el link para la llamada
        String link = llamarPorWhatsapp(numeroDeTelefono);
        System.out.println("El link para realizar la llamada a " + telefono + " es el siguiente: ");
        System.out.println(link);
    }

    public static String llamarPorWhatsapp(String numeroDeTelefono){
        String link = "https://api.whatsapp.com/send?phone=" + numeroDeTelefono;
        return link;
    }

}