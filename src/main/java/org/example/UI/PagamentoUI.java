package org.example.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import org.example.model.Pedido;
import org.example.observer.PedidoSubject;
import org.example.pagamento.CartaoCredito;
import org.example.pagamento.CartaoDebito;
import org.example.pagamento.adaptee.CartaoVA;
import org.example.pagamento.adaptee.PayPal;
import org.example.pagamento.adapter.CartaoVAAdapter;
import org.example.pagamento.adapter.PayPalAdapter;


public class PagamentoUI extends JFrame {

    private Pedido pedido;
    private PedidoSubject pedidoSubject;

    private JComboBox<String> formasPagamento;

    public PagamentoUI(Pedido pedido, PedidoSubject pedidoSubject) {
        this.pedido = pedido;
        this.pedidoSubject = pedidoSubject;

        setTitle("Pagamento");
        setSize(300, 150);
        setLayout(null);

        formasPagamento = new JComboBox<>(new String[]{
                "Cartão Crédito",
                "Cartão Débito",
                "Vale Alimentação",
                "PayPal"
        });

        formasPagamento.setBounds(50, 20, 200, 25);
        add(formasPagamento);

        JButton confirmar = new JButton("Confirmar");
        confirmar.setBounds(80, 60, 120, 25);
        add(confirmar);

        confirmar.addActionListener(this::processarPagamento);

        setVisible(true);
    }

    private void processarPagamento(ActionEvent e) {

        String opcao = (String) formasPagamento.getSelectedItem();

        if (opcao.equals("Cartão Crédito")) {
            pedido.setPagamento(new CartaoCredito());
        }

        else if (opcao.equals("Cartão Débito")) {
            pedido.setPagamento(new CartaoDebito());
        }

        else if (opcao.equals("Vale Alimentação")) {
            pedido.setPagamento(new CartaoVAAdapter(new CartaoVA()));
        }

        else if (opcao.equals("PayPal")) {
            pedido.setPagamento(new PayPalAdapter(new PayPal()));
        }

        pedidoSubject.setStatus("Pedido em preparo...");

        try { Thread.sleep(1000); } catch (Exception ex) {}

        pedidoSubject.setStatus("Saiu para entrega...");

        try { Thread.sleep(1000); } catch (Exception ex) {}

        pedidoSubject.setStatus("Entrega realizada!");

        pedido.finalizarPedido();

        JOptionPane.showMessageDialog(this,
                "Pagamento realizado!\nTotal: R$ " + pedido.calcularTotal());

        dispose(); // fecha tela pagamento
    }
}