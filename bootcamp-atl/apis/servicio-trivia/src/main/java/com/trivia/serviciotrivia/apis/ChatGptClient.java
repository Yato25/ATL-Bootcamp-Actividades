package com.trivia.serviciotrivia.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivia.serviciotrivia.modelos.Pregunta;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatGptClient {
    public Pregunta generarPregunta(String categoria) {
        String mensaje = "Generame una pregunta de una categoria " + categoria + " que " +
                "tenga la siguiente estructura json. Solo necesito un json no quiero que me des " +
                "ninguna aclaracion. La respuesta no siempre tiene que estar en la primera posicion, " +
                "lo que debe cumplir es que es unica entre las opciones. Necesito que solo haya una" +
                " respuesta correcta. Te paso la estructura de debe seguir la respuesta. Recuerda " +
                "solo JSON y sin nada mas.:\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"{\\n\" +\n" +
                "                \"  \"category\": \"aca va el nombre de la categoria\",\\n\" +\n" +
                "                \"  \"question\": \"aca va la pregunta\",\\n\" +\n" +
                "                \"  \"options\": [\\n\" +\n" +
                "                \"    \"aca va la opcion 1\",\\n\" +\n" +
                "                \"    \"aca va la opcion 2\",\\n\" +\n" +
                "                \"    \"aca va la opcion 3\"\\n\" +\n" +
                "                \"  ],\\n\" +\n" +
                "                \"  \"answer\": aqui va la respuesta correcta en caso de ser la primera es el numero 0 en caso de ser la segunda es el 1 y en caso de ser la tercera es el 2,\\n\" +\n" +
                "                \"  \"explanation\": \"aca tienes que poner una explicacion diciendo porque es la respuesta correcta\"\\n\" +\n" +
                "                \"}";

        String respuestaDeChatGpt = "";
        try {
            // URL de la API de ChatGPT
            URL url = new URL("https://api.openai.com/v1/chat/completions");

            // Establecer la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            // Establecer los encabezados de la solicitud
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer API-KEY");

            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());

            // Crear el cuerpo de la solicitud
            /*
            String requestBody =
                    "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"system\", \"content\": \"Dame una pregunta para un juego de trivia que contenga la siguiente estrucuta category, question, answer, explanation, options \"}, {\"role\": \"user\", \"content\": \"Who won the world series in 2020?\"}]}";
            */
            Prompt prompt = new Prompt("system", mensaje);
            Prompt finalizacion = new Prompt("user", "");
            Prompt[] messages = {prompt, finalizacion};
            GptRequest request = new GptRequest("gpt-3.5-turbo", messages);
            ObjectMapper convertidor = new ObjectMapper();
            String requestBody =  convertidor.writeValueAsString(request);

            // Enviar la solicitud
            outputStream.writeBytes(requestBody);
            outputStream.flush();
            outputStream.close();

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();
            BufferedReader inputReader;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                inputReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            // Leer la respuesta línea por línea
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }
            inputReader.close();
            // Imprimir la respuesta

            // Paso el response a String - esto devuelve un JSON de la api
            respuestaDeChatGpt = response.toString();
            //System.out.println(respuestaDeChatGpt);



        } catch (Exception e) {
            e.printStackTrace();
        }
        // Obtengo el contenido dentro del atributo "content" del json obtenido por la api
        String preguntaJson = getContentFromJson(respuestaDeChatGpt);
        //System.out.println(pregunta);
        // System.out.println(preguntaGenerada);

        // Convierto el json a Pregunta y lo retorno
        return fromJson(preguntaJson);
    }


    private static String getContentFromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray choicesArray = jsonObject.getJSONArray("choices");
        JSONObject messageObject = choicesArray.getJSONObject(0).getJSONObject("message");
        String content = messageObject.getString("content");
        return content;
    }

    public static Pregunta fromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        String category = jsonObject.getString("category");
        String question = jsonObject.getString("question");
        JSONArray optionsArray = jsonObject.getJSONArray("options");
        List<String> options = new ArrayList<>();
        for (int i = 0; i < optionsArray.length(); i++) {
            options.add(optionsArray.getString(i));
        }
        Integer answer = jsonObject.getInt("answer");
        String explanation = jsonObject.getString("explanation");

        return new Pregunta(category, question, options, answer, explanation);
    }

}
