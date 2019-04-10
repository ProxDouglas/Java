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

public class PessoaFiltro {
    
     public int buscarIdPessoa(String cpf){
        String sql = "SELECT idPessoa FROM pessoa WHERE cpf = ?";
        
        int cp = 0;
        
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement pstm = con.prepareStatement(sql);
             pstm.setString(1, cpf);
             ResultSet rs = pstm.executeQuery();
             if(rs.first())
                cp = rs.getInt("idPessoa");
         } catch (SQLException ex) {
             Logger.getLogger(PessoaFiltro.class.getName()).log(Level.SEVERE, null, ex);
         }
         return cp;
    }
}
