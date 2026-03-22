package org.example.decorator.sabores;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class SaborBaunilha extends PedidoDecorator {
    public SaborBaunilha(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Sabor baunilha";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + 2.5;
    }
}
