/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filtros;

import classes.Endereco;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoFiltro {
    
    public int buscarIdEndereco(Endereco endereco){
        
        String sql = "SELECT idEndereco FROM endereco WHERE rua = ? AND bairro = ? AND cidade = ? AND estado = ? AND"
                + " pais = ? AND num = ?";
        
        int id = 0;
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement pstm = con.prepareStatement(sql);
             pstm.setString(1, endereco.getRua());
             pstm.setString(2, endereco.getBairro());
             pstm.setString(3, endereco.getCidade());
             pstm.setString(4, endereco.getEstado());
             pstm.setString(5, endereco.getPais());
             pstm.setInt(6, endereco.getNum());
             ResultSet rs = pstm.executeQuery();
             if(rs.next())
                id = rs.getInt("idEndereco");
         } catch (SQLException ex) {
             Logger.getLogger(EnderecoFiltro.class.getName()).log(Level.SEVERE, null, ex);
         }
         return id;
    }
    
        
}
