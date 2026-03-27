package org.example.UI;

import org.example.model.Usuario;

import javax.swing.*;

public class LoginUI extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    private Usuario[] usuarios = {
            new Usuario("joao", false),
            new Usuario("maria", true)
    };

    public LoginUI() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(20, 20, 80, 25);
        add(labelUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(100, 20, 150, 25);
        add(campoUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(20, 60, 80, 25);
        add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(100, 60, 150, 25);
        add(campoSenha);

        JButton botaoLogin = new JButton("Login");
        botaoLogin.setBounds(100, 120, 100, 25);
        add(botaoLogin);

        botaoLogin.addActionListener(e -> fazerLogin());

        setVisible(true);
    }

    private void fazerLogin() {
        String usuarioDigitado = campoUsuario.getText();

        for (Usuario u : usuarios) {
            if (u.getNome().equals(usuarioDigitado)) {

                JOptionPane.showMessageDialog(this, "Login OK!");

                dispose();

                new PedidoUI(u).setVisible(true);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Usuário inválido!");
    }
}