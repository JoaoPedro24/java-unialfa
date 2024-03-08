package com.unialfa;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SwingUtilities.invokeLater(() -> {
            var tela = new TelaCadastroPessoa();
            tela.setVisible(true);
        });
    }
}