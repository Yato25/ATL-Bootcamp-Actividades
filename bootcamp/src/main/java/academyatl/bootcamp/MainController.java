package academyatl.bootcamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/hacer-algo")
    public String primeraPrueba(){
        // midominio.com/hacer-algo

        return "Hola Mundo";
    }

    @GetMapping("/generar-password")
    public String generarPassword(){
        double aleatorio = Math.random() * 1000000;
        long numeroAleatorio = Math.round(aleatorio);

        String password = "JDg" + numeroAleatorio;
        return password;
    }

    @GetMapping("/transformar-a-codigo-morse/{texto}")
    public String primeraPrueba(@PathVariable String texto){

        String[] tableroAbc = {"A", "B", "c"};
        String[] tablaCodigoMorse = {".-", "-...", "-.-.-"};

        String codigoTransformado = "";

        for(int i = 0; i < texto.length(); i++){
            String letraTexto = "" + texto.charAt(i);

            for(int letra=0; letra < tableroAbc.length; letra++){

                if(letraTexto.equals(tableroAbc[letra])){
                    codigoTransformado = codigoTransformado + " " + tablaCodigoMorse[letra];
                }

            }
        }

        return codigoTransformado;
    }
}
