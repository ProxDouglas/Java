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

public class ClienteFiltro {
    
    private PessoaFiltro filtro = new PessoaFiltro(); 
    
    public int buscarIdCLiente(String cpf){
        String sql = "SELECT idCliente FROM cliente WHERE idPessoa = ?";
        
        int cp = 0;
        
        Connection con = Conexao.getConexao();
         try {
             PreparedStatement pstm = con.prepareStatement(sql);
             pstm.setInt(1,filtro.buscarIdPessoa(cpf));
             ResultSet rs = pstm.executeQuery();
             if(rs.first())
                cp = rs.getInt("idCliente");
         } catch (SQLException ex) {
             Logger.getLogger(PessoaFiltro.class.getName()).log(Level.SEVERE, null, ex);
         }
         return cp;
    }
}
