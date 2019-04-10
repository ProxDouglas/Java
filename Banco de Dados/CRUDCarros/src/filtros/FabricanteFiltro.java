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

public class FabricanteFiltro {
    
    public int recuperarIdFabricante(String nome){
        String sql = "SELECT idFabricante FROM fabricante WHERE nome = ?";
        int id = 0;
        
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery();
            id = rs.getInt("idFabricante");
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteFiltro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String recuperarNomeFabricante(int idFabricante){
        String sql = "SELECT nome FROM fabricante WHERE idFabricante = ?";
        String nome = "";
        
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, idFabricante);
            ResultSet rs = pstm.executeQuery();
            rs.first();
            nome = rs.getString("nome");
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteFiltro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nome;
    }
    
}
