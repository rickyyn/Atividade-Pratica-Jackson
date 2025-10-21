package br.edu.fatecpg.tecprog.comentarios.model;

public class Comentario {
    private String name;
    private String email;


    public Comentario(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                ", nome='" + name + '\'' +
                ", email='" + email + '\'' +
                '\'' +
                '}';
    }
}
