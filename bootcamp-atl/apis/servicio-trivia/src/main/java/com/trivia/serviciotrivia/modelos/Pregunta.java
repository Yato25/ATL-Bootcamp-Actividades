package com.trivia.serviciotrivia.modelos;

import java.util.List;

public class Pregunta {

    private String category;
    private String question;
    private List<String> options;
    private Integer answer;
    private String explanation;

    public Pregunta(String categoria, String pregunta, List<String> opciones,
                    Integer answer, String explanation){

        this.category = categoria;
        this.question = pregunta;
        this.options = opciones;
        this.answer = answer;
        this.explanation = explanation;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getOption(Integer index){ return options.get(index); }

    public Integer getAnswer() {
        return answer;
    }

    public String getExplanation() {
        return explanation;
    }
}
