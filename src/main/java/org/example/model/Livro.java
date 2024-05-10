package org.example.model;

public class Livro {
    private String titulo;
    private String autor;
    private String numeroRegistro;
    private boolean disponivel;

    public Livro(String titulo, String autor, String numeroRegistro) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroRegistro = numeroRegistro;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

