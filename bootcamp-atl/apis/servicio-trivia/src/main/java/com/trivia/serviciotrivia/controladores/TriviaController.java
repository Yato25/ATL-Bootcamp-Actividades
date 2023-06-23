package com.trivia.serviciotrivia.controladores;


import com.trivia.serviciotrivia.modelos.Categoria;
import com.trivia.serviciotrivia.modelos.Pregunta;
import com.trivia.serviciotrivia.servicios.ServicioTrivia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TriviaController {
    private final ServicioTrivia servicioTrivia;
    public TriviaController(ServicioTrivia servicioTrivia) {
        this.servicioTrivia = servicioTrivia;
    }
    @GetMapping("/categories")
    public List<Categoria> getCategories(){
        return servicioTrivia.getAllCategories();
    }

    @GetMapping("/question/{category}")
    public Pregunta getQuestion(@PathVariable String category){
        Pregunta pregunta = servicioTrivia.getQuestion(category);
        return  pregunta;
    }

}
