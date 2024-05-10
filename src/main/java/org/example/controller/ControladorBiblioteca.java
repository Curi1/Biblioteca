package org.example.controller;

import org.example.model.Biblioteca;
import org.example.model.Livro;
import org.example.view.VisaoBiblioteca;

import java.util.List;

public class ControladorBiblioteca {
    private Biblioteca biblioteca;
    private VisaoBiblioteca visao;

    public ControladorBiblioteca(Biblioteca biblioteca, VisaoBiblioteca visao) {
        this.biblioteca = biblioteca;
        this.visao = visao;
    }

    public void executar() {
        boolean executando = true;
        while (executando) {
            visao.printMessage("1. Adicionar Livro\n2. Buscar por Título\n3. Buscar por Autor\n4. Emprestar Livro\n5. Devolver Livro\n6. Sair");
            String escolha = visao.getInput();
            switch (escolha) {
                case "1":
                    adicionarLivro();
                    break;
                case "2":
                    buscarPorTitulo();
                    break;
                case "3":
                    buscarPorAutor();
                    break;
                case "4":
                    emprestarLivro();
                    break;
                case "5":
                    devolverLivro();
                    break;
                case "6":
                    executando = false;
                    visao.printMessage("Saindo...");
                    break;
                default:
                    visao.printMessage("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private void adicionarLivro() {
        visao.printMessage("Digite o Título:");
        String titulo = visao.getInput();
        visao.printMessage("Digite o Autor:");
        String autor = visao.getInput();
        visao.printMessage("Digite o Número de Registro:");
        String numReg = visao.getInput();
        biblioteca.adicionarLivro(new Livro(titulo, autor, numReg));
        visao.printMessage("Livro adicionado com sucesso!");
    }

    private void buscarPorTitulo() {
        visao.printMessage("Digite o Título:");
        String titulo = visao.getInput();
        List<Livro> livrosEncontrados = biblioteca.buscarPorTitulo(titulo);
        if (livrosEncontrados.isEmpty()) {
            visao.printMessage("Nenhum livro encontrado com esse título.");
        } else {
            livrosEncontrados.forEach(livro -> visao.printMessage(livro.getTitulo() + " de " + livro.getAutor() + " - Disponível: " + (livro.isDisponivel() ? "Sim" : "Não")));
        }
    }

    private void buscarPorAutor() {
        visao.printMessage("Digite o Autor:");
        String autor = visao.getInput();
        List<Livro> livrosEncontrados = biblioteca.buscarPorAutor(autor);
        if (livrosEncontrados.isEmpty()) {
            visao.printMessage("Nenhum livro encontrado desse autor.");
        } else {
            livrosEncontrados.forEach(livro -> visao.printMessage(livro.getTitulo() + " de " + livro.getAutor() + " - Disponível: " + (livro.isDisponivel() ? "Sim" : "Não")));
        }
    }

    private void emprestarLivro() {
        visao.printMessage("Digite o Número de Registro do Livro para empréstimo:");
        String numeroRegistro = visao.getInput();
        if (biblioteca.emprestarLivro(numeroRegistro)) {
            visao.printMessage("Livro emprestado com sucesso!");
        } else {
            visao.printMessage("Livro não está disponível ou não existe.");
        }
    }

    private void devolverLivro() {
        visao.printMessage("Digite o Número de Registro do Livro para devolução:");
        String numeroRegistro = visao.getInput();
        if (biblioteca.devolverLivro(numeroRegistro)) {
            visao.printMessage("Livro devolvido com sucesso!");
        } else {
            visao.printMessage("Livro não estava emprestado ou não existe.");
        }
    }
}
