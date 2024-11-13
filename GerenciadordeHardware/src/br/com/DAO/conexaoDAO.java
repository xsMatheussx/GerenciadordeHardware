package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexaoDAO {
    
    // Método estático para estabelecer conexão com o banco de dados
    public static Connection conector() {
        java.sql.Connection conexao = null;  // Declara a variável de conexão

        String driver = "com.mysql.jdbc.Driver";  // Especifica o driver JDBC para o MySQL

        // URL do banco de dados, especificando o nome do banco
        String url = "jdbc:mysql://localhost:3306/sistemamanutencao";
        String user = "root";  // Usuário do banco de dados
        String password = "root";  // Senha do banco de dados

        try {
            // Carrega o driver do MySQL
            Class.forName(driver);
            
            // Estabelece a conexão com o banco de dados usando a URL, usuário e senha
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;  // Retorna a conexão estabelecida

        } catch (Exception e) {
            // Exibe uma mensagem de erro se a conexão falhar
            JOptionPane.showMessageDialog(null, "Conexão" + e);
            return null;  // Retorna null caso a conexão falhe
        }
    }
}
