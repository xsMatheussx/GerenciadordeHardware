package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import br.com.VIEW.TelaAdministrador;
import br.com.VIEW.telaADDmanutencao;
import br.com.VIEW.telaPrincipalVIEW;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class usuarioDAO {

    // Declaração das variáveis para conexão, preparação de declaração e resultado
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método para realizar o login do usuário
    public void logar(UsuarioDTO udto) {

        // Consulta SQL para verificar se o usuário e senha estão corretos
        String sql = "select * from usuarios where nome_usu = ? and senha_usu = ?";
        conexao = new conexaoDAO().conector();  // Estabelece a conexão com o banco de dados
        try {
            // Prepara a consulta SQL para validação do login
            pst = conexao.prepareStatement(sql);
            pst.setString(1, udto.getNome_usu());  // Define o nome do usuário
            pst.setString(2, udto.getSenha_usu());  // Define a senha do usuário

            // Executa a consulta
            rs = pst.executeQuery();
            if (rs.next()) {
                // Se o usuário e senha estão corretos, exibe a tela principal
                telaPrincipalVIEW principal = new telaPrincipalVIEW();
                principal.setVisible(true);
                telaPrincipalVIEW.lblNome.setText(rs.getString(2));  // Exibe o nome do usuário na tela
            } else {
                // Exibe uma mensagem de erro caso o login falhe
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos!!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na tela de login: " + e);
        }
    }

    // Método para cadastrar um novo usuário
    public void cadastrar(UsuarioDTO udto) {

        // Consulta SQL para inserir um novo usuário
        String sql = "insert into usuarios(id_usu, nome_usu, email_usu, senha_usu, perfil_usu) values (?, ?, ?, ?, ?)";
        conexao = new conexaoDAO().conector();

        try {
            // Prepara a consulta SQL para inserção de dados
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, udto.getId_usu());  // Define o ID do usuário
            pst.setString(2, udto.getNome_usu());  // Define o nome do usuário
            pst.setString(3, udto.getEmail_usu());  // Define o email do usuário
            pst.setString(4, udto.getSenha_usu());  // Define a senha do usuário
            pst.setString(5, udto.getPerfil_usu());  // Define o perfil do usuário

            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");  // Mensagem de sucesso
                limpar();  // Limpa os campos de entrada
                preenchertabela();  // Atualiza a tabela de usuários
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário: " + e);
        }
    }

    // Método para pesquisar um usuário pelo ID
    public void pesquisar(UsuarioDTO udto) {

        // Consulta SQL para buscar o usuário pelo ID
        String sql = "select * from usuarios where id_usu = ?";
        conexao = new conexaoDAO().conector();

        try {
            // Prepara a consulta SQL para buscar o usuário
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, udto.getId_usu());  // Define o ID do usuário
            rs = pst.executeQuery();

            if (rs.next()) {
                // Preenche os campos na tela com os dados do usuário encontrado
                TelaAdministrador.txtNome.setText(rs.getString(2));
                TelaAdministrador.txtEmail.setText(rs.getString(3));
                TelaAdministrador.txtSenha.setText(rs.getString(4));
                TelaAdministrador.caixaStatus.setSelectedItem(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "Este usuário não existe!!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método pesquisar: " + e);
        }
    }

    // Método para editar um usuário existente
    public void editar(UsuarioDTO udto) {

        // Consulta SQL para atualizar os dados do usuário
        String sql = "update usuarios set nome_usu = ?, email_usu = ?, senha_usu = ?, perfil_usu = ? where id_usu = ?";
        conexao = conexaoDAO.conector();

        try {
            // Prepara a consulta SQL para atualização de dados
            pst = conexao.prepareStatement(sql);
            pst.setInt(5, udto.getId_usu());  // Define o ID do usuário
            pst.setString(1, udto.getNome_usu());  // Define o novo nome do usuário
            pst.setString(2, udto.getEmail_usu());  // Define o novo email do usuário
            pst.setString(3, udto.getSenha_usu());  // Define a nova senha do usuário
            pst.setString(4, udto.getPerfil_usu());  // Define o novo perfil do usuário

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                limpar();  // Limpa os campos de entrada
                preenchertabela();  // Atualiza a tabela de usuários
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método editar: " + e);
        }
    }

    // Método para excluir um usuário
    public void excluir(UsuarioDTO udto) {

        // Consulta SQL para deletar o usuário pelo ID
        String sql = "delete from usuarios where id_usu = ?";
        conexao = new conexaoDAO().conector();

        try {
            // Prepara a consulta SQL para exclusão
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, udto.getId_usu());  // Define o ID do usuário

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
                limpar();  // Limpa os campos de entrada
                preenchertabela();  // Atualiza a tabela de usuários
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método excluir: " + e);
        }
    }

    // Método para limpar os campos na tela do administrador
    public void limpar() {
        TelaAdministrador.txtID.setText(null);
        TelaAdministrador.txtNome.setText(null);
        TelaAdministrador.txtEmail.setText(null);
        TelaAdministrador.txtSenha.setText(null);
        TelaAdministrador.caixaStatus.setSelectedIndex(0);
    }

    // Método para preencher a tabela de usuários na tela do administrador
    public void preenchertabela() {

        // Consulta SQL para selecionar todos os usuários
        String sql = "select * from usuarios";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            // Obtém o modelo da tabela e redefine para atualizar os dados
            DefaultTableModel model = (DefaultTableModel) TelaAdministrador.tabelaUsuarios.getModel();
            model.setRowCount(0);

            // Preenche a tabela com os dados de cada usuário
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_usu"),
                    rs.getString("nome_usu"),
                    rs.getString("perfil_usu")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e);
        }
    }
}
