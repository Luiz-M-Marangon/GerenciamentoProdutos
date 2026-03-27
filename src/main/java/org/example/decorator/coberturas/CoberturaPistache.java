package org.example.decorator.coberturas;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class CoberturaPistache extends PedidoDecorator {

    private static double preco = 8.0;

    public static void setPreco(double preco) {
        CoberturaPistache.preco = preco;
    }

    public CoberturaPistache(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Cobertura pistache";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + preco;
    }
}
