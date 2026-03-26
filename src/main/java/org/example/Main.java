package org.example;

import org.example.decorator.ItemPedido;
import org.example.decorator.ItemPedidoBasico;
import org.example.decorator.coberturas.CoberturaNinho;
import org.example.decorator.coberturas.CoberturaNutella;
import org.example.decorator.coberturas.CoberturaPistache;
import org.example.decorator.sabores.SaborBaunilha;
import org.example.decorator.sabores.SaborChocolate;
import org.example.decorator.sabores.SaborMorango;
import org.example.decorator.tamanhos.TamanhoGrande;
import org.example.decorator.tamanhos.TamanhoMedio;
import org.example.factory.ProdutoFactory;
import org.example.model.Pedido;
import org.example.model.Produto;
import org.example.model.Usuario;
import org.example.observer.ClienteObserver;
import org.example.pagamento.CartaoCredito;
import org.example.pagamento.adaptee.CartaoVA;
import org.example.pagamento.adapter.CartaoVAAdapter;
import org.example.proxy.ProdutoService;
import org.example.proxy.ProdutoServiceProxy;
import org.example.proxy.ProdutoServiceReal;

public class Main {
    public static void main(String[] args){
        // Proxy (controle de acesso)
        Usuario usuario = new Usuario("João", true);
        ProdutoService service = new ProdutoServiceProxy(
                new ProdutoServiceReal(),
                usuario
        );
        service.listarProdutos();

        // Pedido
        Pedido pedido = new Pedido();

        // Observer
        pedido.adicionarObserver(new ClienteObserver("João"));

        // Factory
        Produto produto = ProdutoFactory.createProduto("bolo", "simples", "bolo massa");

        // Decorator utilizado no SWING para seleção de sabores, coberturas e tamanhos respectivamente
        ItemPedido item = new ItemPedidoBasico(produto);
        item = new SaborChocolate(item);
        item = new SaborBaunilha(item);
        item = new SaborMorango(item);
        item = new CoberturaNutella(item);
        item = new CoberturaNinho(item);
        item = new CoberturaPistache(item);
        item = new TamanhoMedio(item);
        item = new TamanhoGrande(item); //DEPENDENDO DA POSIÇÃO EM QUE FOR ADICIONADO, O CÁLCULO MUDA RESULTADO FINAL

        // Adiciona ao pedido
        pedido.adicionarItem(item);


        // Adapter (pagamento)
        pedido.setPagamento(new CartaoVAAdapter(new CartaoVA()));

        // Finaliza
        pedido.finalizarPedido();
    }
}
