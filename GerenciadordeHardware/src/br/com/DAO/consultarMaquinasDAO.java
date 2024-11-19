package br.com.DAO;

import br.com.VIEW.telaConsultarMaquinasVIEW;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class consultarMaquinasDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método para preencher a tabela de máquinas
    public void preenchertabelaMaq() {
        String sql = "SELECT * FROM equipamentos";
        conexao = new conexaoDAO().conector(); // Obtém a conexão com o banco

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            // Obtém o modelo da tabela e limpa as linhas existentes
            DefaultTableModel model = (DefaultTableModel) telaConsultarMaquinasVIEW.tabelaConsultaMaquina.getModel();
            model.setRowCount(0);

            // Adiciona os dados do banco de dados na tabela
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_eq"),
                    rs.getString("status_equipamento"),
                    rs.getString("id_lab")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexao != null) conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}
    