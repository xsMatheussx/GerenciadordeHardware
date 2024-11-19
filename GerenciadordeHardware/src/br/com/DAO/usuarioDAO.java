package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class usuarioDAO {

    private Connection conexao;  // Conexão com o banco de dados

    // Método para fazer o login do usuário
    public boolean logar(UsuarioDTO usuarioDTO) {
        boolean validado = false;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Estabelece a conexão
            conexao = conexaoDAO.conector();
            
            // Verifica se a conexão foi bem-sucedida
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados falhou.");
                return validado;
            }

            // Comando SQL para verificar se o usuário e a senha correspondem no banco
            String query = "SELECT * FROM usuarios WHERE nome_usu = ? AND senha_usu = ?";
            pst = conexao.prepareStatement(query);
            pst.setString(1, usuarioDTO.getNome_usu());  // Passando o nome de usuário para o comando SQL
            pst.setString(2, usuarioDTO.getSenha_usu());  // Passando a senha para o comando SQL

            // Executa a consulta e obtém o resultado
            rs = pst.executeQuery();

            // Verifica se a consulta retornou algum usuário
            if (rs.next()) {
                validado = true; // Caso o usuário e senha sejam válidos
                System.out.println("Usuário autenticado com sucesso!");
            } else {
                System.out.println("Usuário ou senha incorretos.");
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
            }
        } catch (Exception e) {
            // Exibe uma mensagem de erro em caso de exceção
            JOptionPane.showMessageDialog(null, "Erro ao realizar o login: " + e.getMessage());
        } finally {
            // Fechar os recursos para evitar vazamentos de memória
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexao != null) conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return validado;
    }

    // Método para conectar com o banco de dados (exemplo de implementação)
    public static Connection conectar() {
        Connection conexao = null;
        try {
            conexao = conexaoDAO.conector(); // Método que retorna a conexão do seu DAO de conexão
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    // Métodos não implementados
    public void excluir(UsuarioDTO udto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void editar(UsuarioDTO udto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cadastrar(UsuarioDTO udto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void pesquisar(UsuarioDTO udto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void preenchertabela() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
