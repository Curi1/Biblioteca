package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livros.stream().filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo)).collect(Collectors.toList());
    }

    public List<Livro> buscarPorAutor(String autor) {
        return livros.stream().filter(livro -> livro.getAutor().equalsIgnoreCase(autor)).collect(Collectors.toList());
    }

    public boolean emprestarLivro(String numeroRegistro) {
        Livro livro = livros.stream()
                .filter(l -> l.getNumeroRegistro().equals(numeroRegistro) && l.isDisponivel())
                .findFirst()
                .orElse(null);
        if (livro != null) {
            livro.setDisponivel(false);
            return true;
        }
        return false;
    }

    public boolean devolverLivro(String numeroRegistro) {
        Livro livro = livros.stream()
                .filter(l -> l.getNumeroRegistro().equals(numeroRegistro) && !l.isDisponivel())
                .findFirst()
                .orElse(null);
        if (livro != null) {
            livro.setDisponivel(true);
            return true;
        }
        return false;
    }
}
