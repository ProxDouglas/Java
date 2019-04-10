/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;

import classes.Fabricantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricanteDAO {
    
    public void inserir(Fabricantes fabricante){
        String sql = "INSERT INTO fabricante(nome,paisOrigem,url) VALUES(?,?,?)";
        
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,fabricante.getNome());
            pstm.setString(2, fabricante.getPaisOrigem());
            pstm.setString(3, fabricante.getUrl());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    public ArrayList<Fabricantes> pesquisar(String select,String elem) throws SQLException{
        Connection con = Conexao.getConexao();
        PreparedStatement pstm = null;
        String sql = "SELECT * FROM fabricante";
        
        sql = sql + select;
        ArrayList<Fabricantes> fabricantes = new ArrayList<>();
    
        pstm = con.prepareStatement(sql);
        
        if(!select.equals("") && select != null){
            pstm.setString(1, elem);       }
        
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Fabricantes fab = new Fabricantes();
            fab.setIdFabricante(rs.getInt("idFabricante"));
            fab.setNome(rs.getString("nome"));
            fab.setPaisOrigem(rs.getString("paisOrigem"));
            fab.setUrl(rs.getString("url"));
            fabricantes.add(fab);
        }
        return fabricantes;        
    }
    
    public void editar(Fabricantes fabricante){
        
        String sql = "UPDATE fabricante SET paisOrigem = ? , nome = ? WHERE idFabricante = ?";
        
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, fabricante.getPaisOrigem());
            pstm.setString(2, fabricante.getNome());
            pstm.setInt(3, fabricante.getIdFabricante());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void deletar(Fabricantes fabricante){
        String sql = "DELETE FROM fabricante WHERE idFabricante = ?";
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, fabricante.getIdFabricante());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
