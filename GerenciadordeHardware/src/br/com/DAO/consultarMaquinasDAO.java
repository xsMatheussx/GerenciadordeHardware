
package br.com.DAO;

import br.com.VIEW.TelaAdministrador;
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
    
     public void preenchertabela() {

        String sql = "select * from equipamentos";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) telaConsultarMaquinasVIEW.tabelaConsultaMaquina.getModel();
            model.setRowCount(0);
            
            while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id_eq"),
                rs.getString("status_equipamento"),
                rs.getString("id_lab")
            });
        }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e);
        }

    }
}
