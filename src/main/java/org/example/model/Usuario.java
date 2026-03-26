package org.example.model;

public class Usuario {

    private String nome;
    private boolean gerente;

    public Usuario(String nome, boolean gerente){
        this.nome = nome;
        this.gerente = gerente;
    }

    public boolean isGerente(){
        return gerente;
    }
}