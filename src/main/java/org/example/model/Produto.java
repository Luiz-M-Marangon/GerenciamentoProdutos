package org.example.model;

public abstract class Produto {
    public String nome;
    public String massa;
    public String etiqueta;
    public double preco;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public double getPreco() {return preco;}

    public void setPreco(double preco) {this.preco = preco;}
}
