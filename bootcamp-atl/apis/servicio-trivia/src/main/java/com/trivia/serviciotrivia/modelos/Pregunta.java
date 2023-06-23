package com.trivia.serviciotrivia.modelos;

import java.util.List;

public class Pregunta {

    private String category;
    private String question;
    private List<String> options;
    private Integer answer;
    private String explanation;

    public Pregunta(String category, String question, List<String> options, Integer answer, String explanation) {
        this.category = category;
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
    }

    public  Pregunta(){}

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
