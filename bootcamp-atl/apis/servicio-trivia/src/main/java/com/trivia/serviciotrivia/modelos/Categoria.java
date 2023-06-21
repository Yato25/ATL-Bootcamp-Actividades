package com.trivia.serviciotrivia.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private String category;
    private String description;
    public Categoria(String nombreCategoria, String descripcionCategoria){
        category = nombreCategoria;
        description = descripcionCategoria;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }

}
