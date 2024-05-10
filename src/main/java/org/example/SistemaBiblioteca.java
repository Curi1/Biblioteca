package org.example;
import org.example.controller.ControladorBiblioteca;
import org.example.model.Biblioteca;
import org.example.view.VisaoBiblioteca;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        VisaoBiblioteca visao = new VisaoBiblioteca();
        ControladorBiblioteca controlador = new ControladorBiblioteca(biblioteca, visao);
        controlador.executar();
    }
}
