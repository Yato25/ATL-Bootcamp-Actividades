package autocompletarspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
public class BusquedaController {

    // localhost:8080/busqueda-usuario/java-bootcamp 2023
    @GetMapping("/busqueda-usuario/{busqueda}")
    public List<String> obtenerPalabrasAutocompletar(@PathVariable String busqueda){

        List<String> frasesTipicas = new LinkedList<String>(Arrays.asList("bootcamp de java", "bootcamp de python",
                                                "curso de nodejs", "curso de C", "bootcamp avanzado de java"));

        List<String> resultadoDeLaBusqueda = new LinkedList<>();

        for(String frase: frasesTipicas){
            if(frase.toLowerCase().contains(busqueda.toLowerCase())){
                resultadoDeLaBusqueda.add(frase);
            }
        }

        return resultadoDeLaBusqueda;
    }

}
