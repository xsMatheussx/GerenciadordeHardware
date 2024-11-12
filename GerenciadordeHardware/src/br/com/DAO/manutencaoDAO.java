
package br.com.DAO;

import br.com.DTO.manutencaoDTO;
import br.com.DTO.maquinaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class manutencaoDAO {
    
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void adicionar(manutencaoDTO mdto){
    
        String sql = "insert into manutencoes (id_mn, data_mn, status_mn, horario_mn, tipo_mn, id_eq) values (?, ?, ?, ?, ?, ?)";
        conexao = new conexaoDAO().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, mdto.getId_mn());
            java.sql.Date sqlDate = new java.sql.Date(mdto.getData_mn().getTime());
            pst.setDate(2, sqlDate);
            pst.setString(3, mdto.getStatus_mn());
            pst.setString(4, mdto.getHora_mn());
            pst.setString(5, mdto.getTipo_mn());
            pst.setInt(6, mdto.getMaquina().getId_eq());
            
//            maquinaDTO maqdto = new maquinaDTO();
//            pst.setString(0, maqdto.getStatus());
            
            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Manutenção inserida com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "inserir manutencao" + e);
        }
        
    }
    
    public void editar(manutencaoDTO mdto){
    
        String sql = "update manutencoes set data_mn = ?, status_mn = ?, horario_mn = ?, tipo_mn = ?, id_eq = ? where id_mn = ?";
        conexao = conexaoDAO.conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(6, mdto.getId_mn());
            java.sql.Date sqlDate = new java.sql.Date(mdto.getData_mn().getTime());
            pst.setDate(1, sqlDate);
            pst.setString(2, mdto.getStatus_mn());
            pst.setString(3, mdto.getHora_mn());
            pst.setString(4, mdto.getTipo_mn());
            pst.setInt(5, mdto.getMaquina().getId_eq());
            
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuários editado com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método editar " + e);
        }
        
    }
    
}
