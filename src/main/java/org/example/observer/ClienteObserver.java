package org.example.observer;

import javax.swing.*;
import javax.swing.JTextArea;

public class ClienteObserver implements Observer{

    private String nome;
    private JTextArea area;

    public ClienteObserver(String nome, JTextArea area){
        this.nome = nome;
        this.area = area;
    }

    @Override
    public void update(String mensagem){
        String texto = ("Cliente " + nome + " recebeu: " + mensagem);

        System.out.println(texto);

        if(area != null){
            area.append("\n[STATUS] " + texto);
        }
    }
}
