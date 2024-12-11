package acesso_a_dado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/seu_banco"; // Para PostgreSQL
    // private static final String URL = "jdbc:mysql://localhost:3306/seu_banco"; // Para MySQL
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com o banco de dados", e);
        }
    }
}

