package br.com.DAO;

import br.com.DTO.maquinaDTO;
import br.com.VIEW.telaADDmanutencao;
import br.com.VIEW.telaAdicionarMaquinasVIEW;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class maquinaDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrar(maquinaDTO maqdto) {

        String sql = "insert into equipamentos (id_eq, status_equipamento, id_lab) values (?, ?, ?)";

        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, maqdto.getId_eq());
            pst.setString(2, maqdto.getStatus());
            pst.setInt(3, maqdto.getLaboratorio().getId_lab());

            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Máquina inserido com sucesso!");
                preencherCaixa();
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "inserir maquina" + e);

        }

    }

    public void editar(maquinaDTO maqdto) {

        String sql = "update equipamentos set status_equipamento = ?, id_lab = ? where id_eq = ?";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(3, maqdto.getId_eq());
            pst.setString(1, maqdto.getStatus());
            pst.setInt(2, maqdto.getLaboratorio().getId_lab());

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Máquina editado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método editar " + e);

        }

    }

    public void excluir(maquinaDTO maqdto) {

        String sql = "delete from equipamentos where id_eq = ?";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, maqdto.getId_eq());

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Máquina deletada com sucesso!");
                preencherCaixa();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "método excluir(DAO)" + e);
        }

    }

    public void preencherCaixa() {

        String sql = "select*from equipamentos";
        conexao = new conexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            telaADDmanutencao.caixaIDeq.removeAllItems();
            
            while(rs.next()){
            telaADDmanutencao.caixaIDeq.addItem(rs.getString("id_eq"));
            }
            
            
        } catch (Exception e) {
        }

    }

}
