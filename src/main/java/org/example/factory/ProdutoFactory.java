package org.example.factory;

import org.example.model.Produto;
import org.example.model.produtos.*;

public class ProdutoFactory {

    public static Produto createProduto(String nome, String massa, String etiqueta){

        // utilizado para não gerar erro de String
        nome = nome.trim().toLowerCase();

        Produto produto;

        if (nome.equals("bolo")){
            produto = new Bolo();
        } else if (nome.equals("churros")) {
            produto = new Churros();
        } else if (nome.equals("cookies")) {
            produto = new Cookie();
        } else if (nome.equals("croissant")) {
            produto = new Croissant();
        } else if (nome.equals("donuts")) {
            produto = new Donuts();
        } else {
            throw new IllegalArgumentException("Produto inválido: " + nome);
        }

        // retorna apenas uma unica vez para todos os produtos, não precisando fazer individualmente
        produto.setMassa(massa);
        produto.setEtiqueta(etiqueta);

        return produto;
    }
}
