/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filtros;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcessionariaFiltro {
    
     public int buscarIdConcessionaria(String nome){
        
        String sql = "SELECT idConcessionaria FROM concessionaria WHERE nome = ?";
        int id = 0;
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement pstm = con.prepareStatement(sql);
             pstm.setString(1, nome);
             ResultSet rs = pstm.executeQuery();
             id = rs.getInt("idConcessionaria");
         } catch (SQLException ex) {
             Logger.getLogger(ConcessionariaFiltro.class.getName()).log(Level.SEVERE, null, ex);
         }
        return id;        
    }
     
    public String buscarNomeConcessionaria(int id){
        String sql = "SELECT nome FROM concessionaria WHERE idConcessionaria = ?";
        String ret = "";
        Connection con = Conexao.getConexao();
        PreparedStatement pstm;
        try {
             pstm = con.prepareStatement(sql);
             pstm.setInt(1, id);
             ResultSet rs = pstm.executeQuery();
             rs.first();
             ret = rs.getString("nome");
        } catch (SQLException ex) {
             Logger.getLogger(ConcessionariaFiltro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
}
