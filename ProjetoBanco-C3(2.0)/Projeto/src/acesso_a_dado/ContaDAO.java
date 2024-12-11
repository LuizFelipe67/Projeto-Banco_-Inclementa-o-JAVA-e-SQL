package acesso_a_dado;

import apresentacao.Conta;
import apresentacao.ContaNormal;
import apresentacao.ContaDebEspecial;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    public void salvar(Conta c) {
        String sql = "INSERT INTO contas (numero, saldo, tipo, limite) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNumero());
            stmt.setDouble(2, c.getSaldo());

            if (c instanceof ContaDebEspecial) {
                stmt.setString(3, "DebEspecial");
                stmt.setDouble(4, ((ContaDebEspecial) c).getLimite());
            } else {
                stmt.setString(3, "Normal");
                stmt.setNull(4, Types.NULL);
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Conta> listar() {
        String sql = "SELECT * FROM contas";
        List<Conta> contas = new ArrayList<>();

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String numero = rs.getString("numero");
                double saldo = rs.getDouble("saldo");
                String tipo = rs.getString("tipo");
                double limite = rs.getDouble("limite");

                Conta conta;
                if ("DebEspecial".equals(tipo)) {
                    conta = new ContaDebEspecial(numero, saldo, limite);
                } else {
                    conta = new ContaNormal();
                    conta.setNumero(numero);
                    conta.setSaldo(saldo);
                }

                contas.add(conta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contas;
    }
}

