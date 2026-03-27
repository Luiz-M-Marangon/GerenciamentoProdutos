package org.example.decorator.tamanhos;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class TamanhoMedio extends PedidoDecorator {

    private static double preco = 1.3;

    public static void setPreco(double preco) {
        TamanhoMedio.preco = preco;
    }

    public TamanhoMedio(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Tamanho médio";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() * preco;
    }
}
