package org.example.proxy;

public class ProdutoServiceReal implements ProdutoService {

    @Override
    public void alterarPreco(int id, double novoPreco) {
        System.out.println("Preço do produto " + id + " alterado para: " + novoPreco);
    }
}