package org.example.view;
import java.util.Scanner;


public class VisaoBiblioteca {
    private Scanner scanner = new Scanner(System.in);

    public String getInput() {
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}


