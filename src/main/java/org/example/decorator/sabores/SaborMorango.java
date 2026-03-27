package org.example.decorator.sabores;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class SaborMorango extends PedidoDecorator {

    private static double preco = 2.0;

    public SaborMorango(ItemPedido itempedido){
        super(itempedido);
    }

    public static void setPreco(double preco) {
        SaborMorango.preco = preco;
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Sabor morango\n";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + preco;
    }
}