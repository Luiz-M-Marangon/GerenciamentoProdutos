package org.example.decorator.sabores;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class SaborBaunilha extends PedidoDecorator {

    private static double preco = 2.5;

    public SaborBaunilha(ItemPedido itempedido){
        super(itempedido);
    }

    public static void setPreco(double preco) {
        SaborBaunilha.preco = preco;
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Sabor baunilha";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + preco;
    }
}
