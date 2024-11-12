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

    // Declaração de variáveis de conexão, preparação de declaração e resultado
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método para adicionar um novo laboratório no banco de dados
    public void adicionar(laboratorioDTO labdto) {

        // Consulta para verificar se já existe um laboratório com a mesma letra
        String sqlCheck = "SELECT COUNT(*) FROM laboratorios WHERE letra_lab = ?";
        // Consulta para inserir o novo laboratório
        String sqlInsert = "INSERT INTO laboratorios (id_lab, letra_lab) VALUES (?, ?)";
        conexao = new conexaoDAO().conector();  // Estabelece a conexão com o banco de dados

        try {
            // Prepara a consulta para verificar duplicidade de letra de laboratório
            pst = conexao.prepareStatement(sqlCheck);
            pst.setString(1, labdto.getLetra_lab());  // Define o valor da letra do laboratório
            rs = pst.executeQuery();  // Executa a consulta

            // Se houver resultado na consulta, verifica se já existe um laboratório com essa letra
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    // Exibe mensagem de erro caso o laboratório já exista
                    JOptionPane.showMessageDialog(null, "Já existe um laboratório com essa letra!");
                    return;
                }
            }

            // Prepara a consulta para inserir o novo laboratório
            pst = conexao.prepareStatement(sqlInsert);
            pst.setInt(1, labdto.getId_lab());  // Define o ID do laboratório
            pst.setString(2, labdto.getLetra_lab());  // Define a letra do laboratório

            // Executa a inserção e verifica se houve sucesso
            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();  // Fecha o statement
                JOptionPane.showMessageDialog(null, "Laboratório inserido com sucesso!");
                preenchertabela();  // Atualiza a tabela com os dados
            }

        } catch (Exception e) {
            // Exibe mensagem de erro em caso de falha na inserção
            JOptionPane.showMessageDialog(null, "Erro ao inserir laboratório: " + e.getMessage());
        }
    }

    // Método para editar um laboratório existente
    public void editar(laboratorioDTO labdto) {

        String sql = "update laboratorios set letra_lab = ? where id_lab = ?";  // Consulta de atualização
        conexao = conexaoDAO.conector();  // Conecta ao banco de dados

        try {
            // Prepara a consulta de atualização
            pst = conexao.prepareStatement(sql);
            pst.setInt(2, labdto.getId_lab());  // Define o ID do laboratório
            pst.setString(1, labdto.getLetra_lab());  // Define a nova letra do laboratório

            int add = pst.executeUpdate();  // Executa a atualização
            if (add > 0) {
                conexao.close();  // Fecha a conexão
                JOptionPane.showMessageDialog(null, "Laboratório editado com sucesso!");
                preenchertabela();  // Atualiza a tabela com os dados
            }
        } catch (Exception e) {
            // Exibe mensagem de erro em caso de falha na edição
            JOptionPane.showMessageDialog(null, "Método editar " + e);
        }
    }

    // Método para excluir um laboratório do banco de dados
    public void excluir(laboratorioDTO labdto) {

        String sql = "delete from laboratorios where id_lab = ?";  // Consulta de exclusão
        conexao = new conexaoDAO().conector();  // Conecta ao banco de dados

        try {
            pst = conexao.prepareStatement(sql);  // Prepara a consulta de exclusão
            pst.setInt(1, labdto.getId_lab());  // Define o ID do laboratório a ser excluído

            int add = pst.executeUpdate();  // Executa a exclusão
            if (add > 0) {
                conexao.close();  // Fecha a conexão
                JOptionPane.showMessageDialog(null, "Laboratório deletado com sucesso!");
                preenchertabela();  // Atualiza a tabela com os dados
            }

        } catch (Exception e) {
            // Exibe mensagem de erro em caso de falha na exclusão
            JOptionPane.showMessageDialog(null, "Método deletar(DAO)" + e);
        }
    }

    // Método para preencher a tabela com dados dos laboratórios
    public void preenchertabela() {

        String sql = "select * from laboratorios";  // Consulta para selecionar todos os laboratórios
        conexao = new conexaoDAO().conector();  // Conecta ao banco de dados

        try {
            pst = conexao.prepareStatement(sql);  // Prepara a consulta
            rs = pst.executeQuery();  // Executa a consulta

            // Obtém o modelo da tabela e limpa as linhas existentes
            DefaultTableModel model = (DefaultTableModel) TelaADDlabin.tabelaLabin.getModel();
            model.setRowCount(0);

            // Adiciona cada laboratório como uma nova linha na tabela
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_lab"),  // ID do laboratório
                    rs.getString("letra_lab")});  // Letra do laboratório
            }

        } catch (Exception e) {
            // Exibe mensagem de erro em caso de falha ao preencher a tabela
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e);
        }
    }

    // Método para preencher uma caixa de seleção com IDs dos laboratórios
    public void preencherCaixa() {

        String sql = "select * from laboratorios";  // Consulta para selecionar todos os laboratórios
        conexao = new conexaoDAO().conector();  // Conecta ao banco de dados

        try {
            pst = conexao.prepareStatement(sql);  // Prepara a consulta
            rs = pst.executeQuery();  // Executa a consulta

            // Limpa os itens existentes na caixa de seleção
            telaAdicionarMaquinasVIEW.caixaLaboratorio.removeAllItems();

            // Adiciona cada ID de laboratório como item na caixa de seleção
            while (rs.next()) {
                telaAdicionarMaquinasVIEW.caixaLaboratorio.addItem(rs.getString("id_lab"));
            }

        } catch (Exception e) {
            // Ignora erros silenciosamente
        }
    }
}
