package org.example.factory;

import org.example.model.Produto;
import org.example.model.produtos.*;

public class ProdutoFactory {

    public static Produto createProduto(String nome, String massa, String etiqueta){

        Produto produto = null;

        if (nome.equals("bolo")){
            produto = new Donuts();
        } else if (nome.equals("churros")) {
            produto = new Churros();
        } else if (nome.equals("cookies")) {
            produto = new Cookie();
        } else if (nome.equals("croissant")) {
            produto = new Croissant();
        } else if (nome.equals("donuts")) {
            produto = new Donuts();
        }

        return produto;
    }
}
