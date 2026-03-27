package org.example.UI;

import org.example.decorator.*;
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
import org.example.observer.ClienteObserver;
import org.example.observer.PedidoSubject;
import org.example.pagamento.adaptee.CartaoVA;
import org.example.pagamento.adapter.CartaoVAAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PedidoUI extends JFrame {

    private JComboBox<String> comboProduto;
    //sabors
    private JCheckBox checkChocolate;
    private JCheckBox checkBaunilha;
    private JCheckBox checkMorango;
    //cobertura
    private JCheckBox checkNutella;
    private JCheckBox checkNinho;
    private JCheckBox checkPistache;
    //tamanhos
    private JCheckBox checkGrande;
    private JCheckBox checkMedio;

    private JTextArea areaPedido;

    private PedidoSubject pedidoSubject;

    private Pedido pedido;

//    private String usuario;
//    private String tipo;

    public PedidoUI(String usuario, String tipo) {
        setTitle("Confeitaria- " + usuario + "(" + tipo + ")");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        pedido = new Pedido();

        // Produtos
        comboProduto = new JComboBox<>(new String[]{"bolo", "donuts", "churros", "croissant"});

        // Opções
        //sabores
        checkChocolate = new JCheckBox("Chocolate");
        checkBaunilha = new JCheckBox("Baunilha");
        checkMorango = new JCheckBox("Morango");
        //coberturas
        checkNutella = new JCheckBox("Nutella");
        checkPistache = new JCheckBox("Pistache");
        checkNinho = new JCheckBox("Ninho");
        //tamanhos
        checkGrande = new JCheckBox("Tamanho Grande");
        checkMedio = new JCheckBox("Tamanho Médio");

        JButton btnAdicionar = new JButton("Adicionar ao Pedido");
        JButton btnFinalizar = new JButton("Finalizar Pedido");

        btnFinalizar.addActionListener((ActionEvent e) ->{
            new PagamentoUI(pedido, pedidoSubject);
        });

        areaPedido = new JTextArea(10, 30);
        areaPedido.setEditable(false);

        pedidoSubject = new PedidoSubject(1);
        pedidoSubject.addObserver(new ClienteObserver("Cliente", areaPedido));

        add(comboProduto);
        //sabores
        add(checkChocolate);
        add(checkBaunilha);
        add(checkMorango);
        //coberturas
        add(checkNutella);
        add(checkPistache);
        add(checkNinho);
        //tamanhos
        add(checkGrande);
        add(checkMedio);
        add(btnAdicionar);
        add(btnFinalizar);
        add(new JScrollPane(areaPedido));

        // AÇÃO: adicionar item
        btnAdicionar.addActionListener((ActionEvent e) -> {

            String nome = (String) comboProduto.getSelectedItem();

            Produto produto = ProdutoFactory.createProduto(nome, "simples", "padrão");

            ItemPedido item = new ItemPedidoBasico(produto);

            if (checkChocolate.isSelected()) {
                item = new SaborChocolate(item);
            }

            if (checkBaunilha.isSelected()) {
                item = new SaborBaunilha(item);
            }

            if (checkMorango.isSelected()) {
                item = new SaborMorango(item);
            }

            if (checkNutella.isSelected()) {
                item = new CoberturaNutella(item);
            }

            if (checkPistache.isSelected()) {
                item = new CoberturaPistache(item);
            }

            if (checkNinho.isSelected()) {
                item = new CoberturaNinho(item);
            }

            if (checkMedio.isSelected()) {
                item = new TamanhoMedio(item);
            }

            if (checkGrande.isSelected()) {
                item = new TamanhoGrande(item);
            }

            pedido.adicionarItem(item);

            areaPedido.append(item.getDescricao() + " - R$ " + item.getPreco() + "\n");
        });

        // AÇÃO: finalizar pedido
        btnFinalizar.addActionListener((ActionEvent e) -> {

//            pedido.setPagamento(new CartaoVAAdapter(new CartaoVA()));
//
//            areaPedido.append("\nTOTAL: R$ " + pedido.calcularTotal());

            new PagamentoUI(pedido, pedidoSubject);
//            pedidoSubject.setStatus("Pedido em preparo...");
//
//            try { Thread.sleep(1000); } catch (Exception ex) {}
//
//            pedidoSubject.setStatus("Saiu para entrega...");
//
//            try { Thread.sleep(1000); } catch (Exception ex) {}
//
//            pedidoSubject.setStatus("Entrega realizada!");
//
//            pedido.finalizarPedido();
        });

        JButton logout = new JButton("Logout");
        add(logout);

        logout.addActionListener(e -> {
            dispose();
            new LoginUI();
        });
    }

}