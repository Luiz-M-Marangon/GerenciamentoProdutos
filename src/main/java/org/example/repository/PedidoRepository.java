package org.example.repository;

import org.example.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidoRepository {

    public void salvar(Pedido pedido) {


        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();

            String sql = "INSERT INTO pedido (descricao, total) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pedido.toString());
            stmt.setDouble(2, pedido.calcularTotal());

            stmt.executeUpdate();

            System.out.println("Pedido salvo com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o Pedido: " + e.getMessage());
        }
    }
}
