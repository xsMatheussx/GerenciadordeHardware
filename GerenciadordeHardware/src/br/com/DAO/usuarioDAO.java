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

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logar(UsuarioDTO udto) {

        String sql = "select * from usuarios where nome_usu = ? and senha_usu = ?";
        conexao = new conexaoDAO().conector();
        try {
            //preparar a consulta no banco, em função do que foi inserido nas caixas de texto
            pst = conexao.prepareStatement(sql);
            pst.setString(1, udto.getNome_usu());
            pst.setString(2, udto.getSenha_usu());

            //executar a query
            rs = pst.executeQuery();
            if (rs.next()) {
                telaPrincipalVIEW principal = new telaPrincipalVIEW();
                principal.setVisible(true);//mudamos a visualização da tela 
                telaPrincipalVIEW.lblNome.setText(rs.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos!!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tela de login" + e);
        }

    }

    public void cadastrar(UsuarioDTO udto) {

        String sql = "insert into usuarios(id_usu, nome_usu, email_usu, senha_usu, perfil_usu) values (?, ?, ?, ?, ?)";

        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, udto.getId_usu());
            pst.setString(2, udto.getNome_usu());
            pst.setString(3, udto.getEmail_usu());
            pst.setString(4, udto.getSenha_usu());
            pst.setString(5, udto.getPerfil_usu());
            
            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Usuários inserido com sucesso!");
                limpar();
                preenchertabela();
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "inserir usuário" + e);
        }

    }

    public void pesquisar(UsuarioDTO udto) {

        String sql = "select * from usuarios where id_usu = ?";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, udto.getId_usu());
            rs = pst.executeQuery();

            if (rs.next()) {
                TelaAdministrador.txtNome.setText(rs.getString(2));
                TelaAdministrador.txtEmail.setText(rs.getString(3));
                TelaAdministrador.txtSenha.setText(rs.getString(4));
                TelaAdministrador.caixaStatus.setSelectedItem(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "Este usuário não existe!!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "método pesquisar(DAO)" + e);
        }

    }

    public void editar(UsuarioDTO udto) {

        String sql = "update usuarios set nome_usu = ?, email_usu = ?, senha_usu = ?, perfil_usu = ? where id_usu = ? ";
        conexao = conexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(5, udto.getId_usu());
            pst.setString(1, udto.getNome_usu());
            pst.setString(2, udto.getEmail_usu());
            pst.setString(3, udto.getSenha_usu());
            pst.setString(4, udto.getPerfil_usu());

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuários editado com sucesso!");
                limpar();
                preenchertabela();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método editar " + e);
        }

    }

    public void excluir(UsuarioDTO udto) {

        String sql = "delete from usuarios where id_usu = ?";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, udto.getId_usu());

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
                limpar();
                preenchertabela();
               

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método deletar(DAO)" + e);
        }

    }

    public void limpar() {
        TelaAdministrador.txtID.setText(null);
        TelaAdministrador.txtNome.setText(null);
        TelaAdministrador.txtEmail.setText(null);
        TelaAdministrador.txtSenha.setText(null);
        TelaAdministrador.caixaStatus.setSelectedIndex(0);
    }

    public void preenchertabela() {

        String sql = "select * from usuarios";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) TelaAdministrador.tabelaUsuarios.getModel();
            model.setRowCount(0);
            
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
