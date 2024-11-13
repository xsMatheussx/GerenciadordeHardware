package br.com.DAO;

import br.com.DTO.maquinaDTO;
import br.com.VIEW.telaADDmanutencao;
import br.com.VIEW.telaAdicionarMaquinasVIEW;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class maquinaDAO {

    // Declaração das variáveis para conexão, preparação de declaração e resultado.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método para cadastrar uma nova máquina no banco de dados
    public void cadastrar(maquinaDTO maqdto) {

        // Consulta SQL para inserir uma nova máquina
        String sql = "insert into equipamentos (id_eq, status_equipamento, id_lab) values (?, ?, ?)";
        conexao = new conexaoDAO().conector();  // Estabelece a conexão com o banco de dados

        try {
            // Prepara a consulta SQL para inserção de dados
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, maqdto.getId_eq());  // Define o ID da máquina
            pst.setString(2, maqdto.getStatus());  // Define o status da máquina
            pst.setInt(3, maqdto.getLaboratorio().getId_lab());  // Define o ID do laboratório associado à máquina

            // Executa a inserção no banco de dados
            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();  // Fecha o PreparedStatement
                JOptionPane.showMessageDialog(null, "Máquina inserida com sucesso!");  // Mensagem de sucesso
                preencherCaixa();  // Atualiza o comboBox de IDs de equipamentos
            }
        } catch (Exception e) {
            // Exibe mensagem de erro caso ocorra uma exceção durante a inserção
            JOptionPane.showMessageDialog(null, "Erro ao inserir máquina: " + e);
        }
    }

    // Método para editar uma máquina existente no banco de dados
    public void editar(maquinaDTO maqdto) {

        // Consulta SQL para atualizar os dados de uma máquina existente
        String sql = "update equipamentos set status_equipamento = ?, id_lab = ? where id_eq = ?";
        conexao = new conexaoDAO().conector();  // Estabelece a conexão com o banco de dados

        try {
            // Prepara a consulta SQL para atualização de dados
            pst = conexao.prepareStatement(sql);
            pst.setInt(3, maqdto.getId_eq());  // Define o ID da máquina a ser atualizada
            pst.setString(1, maqdto.getStatus());  // Define o novo status da máquina
            pst.setInt(2, maqdto.getLaboratorio().getId_lab());  // Define o novo ID do laboratório associado

            // Executa a atualização no banco de dados
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();  // Fecha a conexão
                JOptionPane.showMessageDialog(null, "Máquina editada com sucesso!");  // Mensagem de sucesso
            }
        } catch (Exception e) {
            // Exibe mensagem de erro caso ocorra uma exceção durante a atualização
            JOptionPane.showMessageDialog(null, "Erro no método editar: " + e);
        }
    }

    // Método para excluir uma máquina do banco de dados
    public void excluir(maquinaDTO maqdto) {

        // Consulta SQL para deletar uma máquina
        String sql = "delete from equipamentos where id_eq = ?";
        conexao = new conexaoDAO().conector();  // Estabelece a conexão com o banco de dados

        try {
            // Prepara a consulta SQL para exclusão de dados
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, maqdto.getId_eq());  // Define o ID da máquina a ser excluída

            // Executa a exclusão no banco de dados
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();  // Fecha a conexão
                JOptionPane.showMessageDialog(null, "Máquina deletada com sucesso!");  // Mensagem de sucesso
                preencherCaixa();  // Atualiza o comboBox de IDs de equipamentos
            }
        } catch (Exception e) {
            // Exibe mensagem de erro caso ocorra uma exceção durante a exclusão
            JOptionPane.showMessageDialog(null, "Erro no método excluir: " + e);
        }
    }

    // Método para preencher o comboBox de IDs de máquinas na interface
    public void preencherCaixa() {

        // Consulta SQL para selecionar todos os IDs de equipamentos
        String sql = "select * from equipamentos";
        conexao = new conexaoDAO().conector();  // Estabelece a conexão com o banco de dados

        try {
            // Prepara e executa a consulta SQL
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            // Limpa os itens do comboBox antes de adicionar os novos IDs
            telaADDmanutencao.caixaIDeq.removeAllItems();

            // Itera sobre os resultados e adiciona cada ID de equipamento ao comboBox
            while (rs.next()) {
                telaADDmanutencao.caixaIDeq.addItem(rs.getString("id_eq"));
            }
        } catch (Exception e) {
            // Aqui pode-se tratar o erro ou registrar uma mensagem de log, mas está vazio.
        }
    }
}
