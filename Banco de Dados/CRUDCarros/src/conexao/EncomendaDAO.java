package conexao;

import classes.Encomenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EncomendaDAO {
    
     public void inserir(Encomenda encomenda) {

        String sql = "INSERT INTO encomenda(idCliente,idConcessionaria,data_Entrega,idCarro) VALUES(?,?,?,?)";
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, encomenda.getIdCliente());
            pstm.setInt(2, encomenda.getIdConcessionaria());
            pstm.setDate(3, encomenda.getData_Entrega());
            pstm.setInt(4, encomenda.getIdCarro());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EncomendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletar(Encomenda encomenda) {

        String sql = "DELETE FROM encomenda WHERE idEncomenda = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, encomenda.getIdEncomenda());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EncomendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Encomenda encomenda) {

        String sql = "UPDATE encomenda SET idCliente = ? , idConcessionaria = ?, idCarro = ?, data_Entrega = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, encomenda.getIdCliente());
            pstm.setInt(2, encomenda.getIdConcessionaria());
            pstm.setInt(3, encomenda.getIdCarro());
            pstm.setDate(4, encomenda.getData_Entrega());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EncomendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Encomenda> buscar(String select,String element) throws SQLException{
      
        String sql = "SELECT * FROM encomenda";
        sql = sql + select;
        
        Connection con = Conexao.getConexao();
        PreparedStatement pstm = con.prepareStatement(sql);
        ArrayList<Encomenda> encomendas = new ArrayList<>();
        
        if(select != null){
            pstm.setString(1, element);
        }        
        
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Encomenda enc = new Encomenda();
            enc.setIdEncomenda(rs.getInt("idEncomenda"));
            enc.setIdCarro(rs.getInt("idCarro"));
            enc.setIdCliente(rs.getInt("idCliente"));
            enc.setIdConcessionaria(rs.getInt("idConcessionaria"));
            enc.setData_Entrega(rs.getDate("data_Entrega"));
            encomendas.add(enc);
        }          
        return encomendas;        
    } 
    
}
