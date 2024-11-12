package br.com.DAO;

import br.com.VIEW.TelaAdministrador;
import br.com.VIEW.telaConsultarMaquinasVIEW;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class consultarMaquinasDAO {

    // Declaração das variáveis para conexão, preparação de declaração e resultado
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    // Método para preencher a tabela de máquinas na interface
    public void preenchertabela() {

        String sql = "select * from equipamentos";  // Consulta SQL para selecionar todos os equipamentos
        conexao = new conexaoDAO().conector();  // Estabelece a conexão com o banco de dados

        try {
            // Prepara a consulta SQL
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();  // Executa a consulta e armazena o resultado em rs
            
            // Obtém o modelo da tabela na interface gráfica e limpa as linhas existentes
            DefaultTableModel model = (DefaultTableModel) telaConsultarMaquinasVIEW.tabelaConsultaMaquina.getModel();
            model.setRowCount(0);

            // Itera sobre os resultados da consulta e adiciona cada equipamento como uma nova linha na tabela
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_eq"),  // Obtém o ID do equipamento
                    rs.getString("status_equipamento"),  // Obtém o status do equipamento
                    rs.getString("id_lab")  // Obtém o ID do laboratório ao qual o equipamento pertence
                });
            }

        } catch (Exception e) {
            // Exibe uma mensagem de erro caso ocorra uma exceção ao preencher a tabela
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e);
        }
    }
}
