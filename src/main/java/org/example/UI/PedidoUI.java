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
import org.example.model.Usuario;
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
    private Usuario usuario;

    public PedidoUI(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Confeitaria- " + usuario.getNome() + (usuario.isGerente() ? "(Gerente)" : "(Funcionario)"));
        setSize(800, 500);
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

        if (usuario.isGerente()) {
            JButton btnAlterarPreco = new JButton("Alterar Preço");
            add(btnAlterarPreco);

            btnAlterarPreco.addActionListener(e -> alterarPreco());
        }

        btnFinalizar.addActionListener((ActionEvent e) ->{
            new PagamentoUI(pedido, pedidoSubject);
        });

        areaPedido = new JTextArea(20, 50);
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
            new PagamentoUI(pedido, pedidoSubject);
        });

        JButton logout = new JButton("Logout");
        add(logout);

        logout.addActionListener(e -> {
            dispose();
            new LoginUI();
        });
    }

    private void alterarPreco() {

        int selecionados = 0;

        if (checkChocolate.isSelected()) selecionados++;
        if (checkBaunilha.isSelected()) selecionados++;
        if (checkMorango.isSelected()) selecionados++;

        if (checkNutella.isSelected()) selecionados++;
        if (checkNinho.isSelected()) selecionados++;
        if (checkPistache.isSelected()) selecionados++;

        if (checkMedio.isSelected()) selecionados++;
        if (checkGrande.isSelected()) selecionados++;

        if (selecionados == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um item!");
            return;
        }

        if (selecionados > 1) {
            JOptionPane.showMessageDialog(this, "Selecione apenas UM item!");
            return;
        }

        String novoPrecoStr = JOptionPane.showInputDialog("Novo preço:");

        try {
            double novoPreco = Double.parseDouble(novoPrecoStr);

            // SABORES
            if (checkChocolate.isSelected()) SaborChocolate.setPreco(novoPreco);
            if (checkBaunilha.isSelected()) SaborBaunilha.setPreco(novoPreco);
            if (checkMorango.isSelected()) SaborMorango.setPreco(novoPreco);

            // COBERTURAS
            if (checkNutella.isSelected()) CoberturaNutella.setPreco(novoPreco);
            if (checkNinho.isSelected()) CoberturaNinho.setPreco(novoPreco);
            if (checkPistache.isSelected()) CoberturaPistache.setPreco(novoPreco);

            // TAMANHOS
            if (checkMedio.isSelected()) TamanhoMedio.setPreco(novoPreco);
            if (checkGrande.isSelected()) TamanhoGrande.setPreco(novoPreco);

            JOptionPane.showMessageDialog(this, "Preço atualizado!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Valor inválido!");
        }
    }

}