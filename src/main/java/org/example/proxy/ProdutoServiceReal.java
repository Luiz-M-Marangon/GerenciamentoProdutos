package org.example.proxy;

import java.util.Arrays;
import java.util.List;

public class ProdutoServiceReal implements ProdutoService {

    @Override
    public void alterarPreco(int id, double novoPreco) {
        System.out.println("Preço do produto " + id + " alterado para: " + novoPreco);
    }

    @Override
    public void listarProdutos() {
        List<String> produtos = Arrays.asList("Bolo", "Donut", "Churros", "Croissant");

        System.out.println("Produtos disponíveis:");
        for (String p : produtos) {
            System.out.println("- " + p);
        }
    }
}