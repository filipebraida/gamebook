package br.ufrrj.im.bigtrayenterprises.comp2.aa;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;

import java.util.Scanner;

public class StandardMain implements IOSource {

    public static void main(String[] args) {
        Engine.source = new StandardMain();
        Engine eng = new Engine();
        eng.run();
    }

    public StandardMain() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void printString(String str) {
        System.out.println(str);
    }

    @Override
    public void addChoice(Choice choice) {
        String out = String.format("%d: %s", choice.getNumber(), choice.getDescription());
        printString(out);
    }

    @Override
    public int getChoice() {
        return scanner.nextInt();
    }

    private Scanner scanner;
}
