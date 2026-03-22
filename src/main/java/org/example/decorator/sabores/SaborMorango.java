package org.example.decorator.sabores;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class SaborMorango extends PedidoDecorator {
    public SaborMorango(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Sabor morango";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + 2.0;
    }
}