package com.trivia.serviciotrivia.apis;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

public class Prompt {

    private String role;
    private String content;

    public Prompt(String role, String content){
        this.role = role;
        this.content = content;
    }


    public Prompt(){}


    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setContent(){
        this.content = content;
    }

}
