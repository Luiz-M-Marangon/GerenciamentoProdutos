package org.example.observer;

public class ClienteObserver implements Observer{

    private String nome;

    public ClienteObserver(String nome){
        this.nome = nome;
    }

    @Override
    public void update(String mensagem){
        System.out.println("Cliente " + nome + " recebeu: " + mensagem);
    }
}
