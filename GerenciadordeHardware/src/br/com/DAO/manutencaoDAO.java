package br.com.DAO;

import br.com.DTO.manutencaoDTO;
import br.com.DTO.maquinaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class manutencaoDAO {

    // Declaração das variáveis para conexão, preparação de declaração e resultado
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método para adicionar uma nova manutenção no banco de dados
    public void adicionar(manutencaoDTO mdto) {

        // Consulta SQL para inserir uma nova manutenção
        String sql = "insert into manutencoes (id_mn, data_mn, status_mn, horario_mn, tipo_mn, id_eq) values (?, ?, ?, ?, ?, ?)";
        conexao = new conexaoDAO().conector();  // Estabelece a conexão com o banco de dados

        try {
            // Prepara a consulta SQL para inserção de dados
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, mdto.getId_mn());  // Define o ID da manutenção
            java.sql.Date sqlDate = new java.sql.Date(mdto.getData_mn().getTime());  // Converte a data para o formato SQL
            pst.setDate(2, sqlDate);  // Define a data da manutenção
            pst.setString(3, mdto.getStatus_mn());  // Define o status da manutenção
            pst.setString(4, mdto.getHora_mn());  // Define o horário da manutenção
            pst.setString(5, mdto.getTipo_mn());  // Define o tipo de manutenção
            pst.setInt(6, mdto.getMaquina().getId_eq());  // Define o ID da máquina associada à manutenção
            
            // Executa a inserção no banco de dados
            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();  // Fecha o PreparedStatement
                JOptionPane.showMessageDialog(null, "Manutenção inserida com sucesso!");  // Mensagem de sucesso
            }
        } catch (Exception e) {
            // Exibe mensagem de erro caso ocorra uma exceção durante a inserção
            JOptionPane.showMessageDialog(null, "inserir manutencao" + e);
        }
    }

    // Método para editar uma manutenção existente no banco de dados
    public void editar(manutencaoDTO mdto) {

        // Consulta SQL para atualizar os dados de uma manutenção existente
        String sql = "update manutencoes set data_mn = ?, status_mn = ?, horario_mn = ?, tipo_mn = ?, id_eq = ? where id_mn = ?";
        conexao = conexaoDAO.conector();  // Estabelece a conexão com o banco de dados

        try {
            // Prepara a consulta SQL para atualização de dados
            pst = conexao.prepareStatement(sql);
            pst.setInt(6, mdto.getId_mn());  // Define o ID da manutenção que será atualizada
            java.sql.Date sqlDate = new java.sql.Date(mdto.getData_mn().getTime());  // Converte a data para o formato SQL
            pst.setDate(1, sqlDate);  // Define a nova data da manutenção
            pst.setString(2, mdto.getStatus_mn());  // Define o novo status da manutenção
            pst.setString(3, mdto.getHora_mn());  // Define o novo horário da manutenção
            pst.setString(4, mdto.getTipo_mn());  // Define o novo tipo de manutenção
            pst.setInt(5, mdto.getMaquina().getId_eq());  // Define o novo ID da máquina associada à manutenção

            // Executa a atualização no banco de dados
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();  // Fecha a conexão
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");  // Mensagem de sucesso
            }
        } catch (Exception e) {
            // Exibe mensagem de erro caso ocorra uma exceção durante a atualização
            JOptionPane.showMessageDialog(null, "Método editar " + e);
        }
    }
}
