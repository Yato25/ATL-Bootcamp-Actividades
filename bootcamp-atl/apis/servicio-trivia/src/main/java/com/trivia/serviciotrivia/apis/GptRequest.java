package com.trivia.serviciotrivia.apis;

public class GptRequest {

    private String model;
    private Prompt[] messages;

    public GptRequest(){}

    public GptRequest(String model, Prompt[] messages){
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Prompt[] getMessages() {
        return messages;
    }

    public void setMessages(Prompt[] messages) {
        this.messages = messages;
    }
}
