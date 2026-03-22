package org.example.decorator.tamanhos;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class TamanhoGrande extends PedidoDecorator {
    public TamanhoGrande(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Tamanho grande";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() * 1.5;
    }
}
