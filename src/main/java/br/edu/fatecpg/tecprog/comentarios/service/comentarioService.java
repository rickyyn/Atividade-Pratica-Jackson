package br.edu.fatecpg.tecprog.comentarios.service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class comentarioService {
    private static final String API_URL = "https://jsonplaceholder.typicode.com/comments";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$";;
    private final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    private List<String> emailsValidos = new ArrayList<>();
    private List<String> emailsInvalidos = new ArrayList<>();

    public void processarComentarios() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream input = conn.getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode comentarios = mapper.readTree(input);

            for (JsonNode comentario : comentarios) {
                String email = comentario.get("email").asText();
                if (isEmailValido(email)) {
                    emailsValidos.add(email);
                } else {
                    emailsInvalidos.add(email);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isEmailValido(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public List<String> getEmailsValidos() {
        return emailsValidos;
    }

    public List<String> getEmailsInvalidos() {
        return emailsInvalidos;
    }

    public int countValidos() {
        return emailsValidos.size();
    }

    public int countInvalidos() {
        return emailsInvalidos.size();
    }
}
