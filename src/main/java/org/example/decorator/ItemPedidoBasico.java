package org.example.decorator;

import org.example.model.Produto;

public class ItemPedidoBasico implements ItemPedido {

    private Produto produto;

    private static double precoBolo = 20.0;
    private static double precoDonuts = 10.0;
    private static double precoChurros = 8.0;
    private static double precoCroissant = 12.0;

    public ItemPedidoBasico(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String getDescricao(){
        return produto.getNome();
    }

    @Override
    public double getPreco(){ //não retorna valor padrão, pois valores se encontram nos itens individuais
        return produto.getPreco();
    }

}