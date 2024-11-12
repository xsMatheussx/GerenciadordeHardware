package br.com.DAO;

import br.com.DTO.laboratorioDTO;
import br.com.VIEW.TelaADDlabin;
import br.com.VIEW.telaAdicionarMaquinasVIEW;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class addLabinDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void adicionar(laboratorioDTO labdto) {

        String sqlCheck = "SELECT COUNT(*) FROM laboratorios WHERE letra_lab = ?";
        String sqlInsert = "INSERT INTO laboratorios (id_lab, letra_lab) VALUES (?, ?)";
        conexao = new conexaoDAO().conector();

        try {

            pst = conexao.prepareStatement(sqlCheck);
            pst.setString(1, labdto.getLetra_lab());
            rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {

                    JOptionPane.showMessageDialog(null, "Já existe um laboratório com essa letra!");
                    return;
                }
            }

            pst = conexao.prepareStatement(sqlInsert);
            pst.setInt(1, labdto.getId_lab());
            pst.setString(2, labdto.getLetra_lab());

            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Laboratório inserido com sucesso!");
                preenchertabela();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir laboratório: " + e.getMessage());
        }
    }

    public void editar(laboratorioDTO labdto) {

        String sql = "update laboratorios set letra_lab = ? where id_lab = ?";
        conexao = conexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(2, labdto.getId_lab());
            pst.setString(1, labdto.getLetra_lab());

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Laboratório editado com sucesso!");
                preenchertabela();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método editar " + e);
        }

    }

    public void excluir(laboratorioDTO labdto) {

        String sql = "delete from laboratorios where id_lab = ?";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, labdto.getId_lab());

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Laboratorio deletado com sucesso!");
                preenchertabela();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método deletar(DAO)" + e);
        }

    }

    public void preenchertabela() {

        String sql = "select * from laboratorios";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) TelaADDlabin.tabelaLabin.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_lab"),
                    rs.getString("letra_lab"),});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e);
        }

    }
    
    public void preencherCaixa(){
    
        String sql = "select*from laboratorios";
        conexao = new conexaoDAO().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            telaAdicionarMaquinasVIEW.caixaLaboratorio.removeAllItems();
            
            while(rs.next()){
            telaAdicionarMaquinasVIEW.caixaLaboratorio.addItem(rs.getString("id_lab"));
            }
                    
        } catch (Exception e) {
        }
        
    }
}
