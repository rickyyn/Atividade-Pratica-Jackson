package br.edu.fatecpg.tecprog.comentarios.view;

import br.edu.fatecpg.tecprog.comentarios.service.comentarioService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        comentarioService service = new comentarioService();
        service.processarComentarios();
        List<String> validos = service.getEmailsValidos();
        List<String> invalidos = service.getEmailsInvalidos();
        System.out.println("Total de válidos: " + service.countValidos());
        System.out.println("Total de inválidos: " + service.countInvalidos());

    }
}
