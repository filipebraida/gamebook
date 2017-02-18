package br.ufrrj.im.bigtrayenterprises.comp2.aa.UI;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Engine;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.IOSource;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

public class FormMain implements IOSource, ActionListener {
    // There might be syncronization issues related to the way I'm duct taping
    // this GUI into the IOSource system.
    // but hopefully those were fixed by the semaphores

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormMain");
        FormMain frm = new FormMain();
        frame.setContentPane(frm.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300, 300);


        Engine eng = new Engine();
        Engine.source = frm;
        eng.run();
    }

    public FormMain() {
        chosenChoice = 0;
        chosenSemaphore = new Semaphore(1);

        // needed because IDEA is stupid
        buttonsPane.setLayout(new BoxLayout(buttonsPane, BoxLayout.Y_AXIS));


        // needed because the stupid design decisions never seem to end in this language
        DefaultCaret caret = (DefaultCaret) outputArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    @Override
    public void printString(String str) {
        outputArea.append(str + "\n");
    }

    @Override
    public void addChoice(Choice choice) {
        JButton btn = new JButton(choice.getDescription());
        btn.addActionListener(this);
        btn.setActionCommand(Integer.toString(choice.getNumber())); // this is actually a terrible idea
        buttonsPane.add(btn);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setVisible(true);

        buttonsPane.revalidate();
        buttonsPane.repaint();

        chosenSemaphore.tryAcquire();
    }

    @Override
    public int getChoice() {
        try {
            chosenSemaphore.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return chosenChoice;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        chosenChoice = Integer.parseInt(actionEvent.getActionCommand());

        buttonsPane.removeAll();
        buttonsPane.revalidate();
        buttonsPane.repaint(); // this is swing/awt/whatever being stupid

        chosenSemaphore.release();
    }

    private Semaphore chosenSemaphore;
    private int chosenChoice;


    private JPanel mainPanel;
    private JTextArea outputArea;
    private JPanel buttonsPane;
}
