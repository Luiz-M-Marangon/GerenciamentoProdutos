package org.example.decorator.tamanhos;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class TamanhoGrande extends PedidoDecorator {

    private static double preco = 1.5;

    public static void setPreco(double preco) {
        TamanhoGrande.preco = preco;
    }

    public TamanhoGrande(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Tamanho grande";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() * preco;
    }
}
