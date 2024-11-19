package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoDAO {
    // Substitua com as suas informações do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/projetoaplicadoII";
    private static final String USER = "root";
    private static final String PASSWORD = "C74a03e29";

    public static Connection conector() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
        return conexao;
    }
}
