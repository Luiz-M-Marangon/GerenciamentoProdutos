package org.example.decorator.sabores;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class SaborChocolate extends PedidoDecorator {
    private static double preco = 2.0;

    public SaborChocolate(ItemPedido itempedido){
        super(itempedido);
    }

    public static void setPreco(double preco) {
        SaborChocolate.preco = preco;
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Sabor chocolate";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + preco;
    }
}
