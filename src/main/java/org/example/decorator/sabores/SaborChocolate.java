package org.example.decorator.sabores;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class SaborChocolate extends PedidoDecorator {
    public SaborChocolate(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Sabor chocolate";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + 2.0;
    }
}
