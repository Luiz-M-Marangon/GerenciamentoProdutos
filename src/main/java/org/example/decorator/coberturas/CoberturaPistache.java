package org.example.decorator.coberturas;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class CoberturaPistache extends PedidoDecorator {
    public CoberturaPistache(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Cobertura pistache";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + 4;
    }
}
