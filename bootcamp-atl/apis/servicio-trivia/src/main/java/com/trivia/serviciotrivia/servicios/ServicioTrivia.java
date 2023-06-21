package com.trivia.serviciotrivia.servicios;

import com.trivia.serviciotrivia.modelos.Categoria;
import com.trivia.serviciotrivia.modelos.Pregunta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class ServicioTrivia {

    private List<Categoria> categorias;
    private List<Pregunta> preguntas;

    public ServicioTrivia() {
        categorias = new ArrayList<Categoria>();
        preguntas = new ArrayList<Pregunta>();
        // Añadir desde JSON
        // Agarrar el JSON y pasar a objetos

        // Esto es a mano
        Categoria deportes = new Categoria("Deportes", "temas de deportes");
        List<String> listaDeOpciones = new ArrayList<String>();
        listaDeOpciones.add("Papa Noel");
        listaDeOpciones.add("Messi");
        listaDeOpciones.add("Pele");
        Pregunta preguntaDeDeportes = new Pregunta("Deportes", "¿Quien fue el campeon del mundo en 2023?",
                listaDeOpciones, 1, "Messi fue el campeon del mundo en 2023");


        Categoria arte = new Categoria("Arte", "temas de arte");
        Pregunta preguntaDeArte = new Pregunta("Arte", "¿Quien pinto la Mona Lisa?",
                List.of("paulo cohelo", "miranda", "paulo picasso"), 2, "Picasso fue un gran artista el cual pinto a la Mona Lisa");


        Categoria cultura = new Categoria("Cultura", "temas de cultura");
        Pregunta preguntaDeCultura = new Pregunta("Cultura", "¿Quien invento la bombilla?",
                List.of("nikola tesla", "steve jobs", "thomas edyson"), 2, "Edyson fue el inventor de la bombilla asi como de otros inventos");

        Categoria cine = new Categoria("Cine", "temas de cine");
        Pregunta preguntaDeCine = new Pregunta("Cine", "¿Quienes son los protagonistas de Rapidos y Furiosos 10?",
                                    List.of("El pelado y el facha", "Los autos", "No existe esa pelicula"), 0,
                            "Rapidos y furiosos fueron una banda");

        Categoria series = new Categoria("Series", "temas de series");
        Pregunta preguntaDeSerie = new Pregunta("Series", "¿Existe la serie de Big Bang Theory?",
                                                List.of("No", "Si", "Si, pero ya dejo de existir"), 1
                                                 , "Si, sigue siendo transmitida en la television");

        preguntas.add(preguntaDeArte);
        preguntas.add(preguntaDeCultura);
        preguntas.add(preguntaDeDeportes);
        preguntas.add(preguntaDeCine);
        preguntas.add(preguntaDeSerie);

        categorias.add(deportes);
        categorias.add(arte);
        categorias.add(cultura);
        categorias.add(cine);
        categorias.add(series);
    }

    public List<Categoria> getAllCategories() {
        return categorias;
    }
    public List<Pregunta> getAllQuestions(){
        return  preguntas;
    }
    public Pregunta getQuestion(String category) {
        List<Pregunta> preguntasDeCategoria = preguntas.stream().filter( x -> x.getCategory().equalsIgnoreCase(category)).toList();
        return preguntasDeCategoria.get(0);
    }
}
