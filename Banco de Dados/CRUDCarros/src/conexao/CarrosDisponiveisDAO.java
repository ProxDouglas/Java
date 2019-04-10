package conexao;

import classes.CarrosDisponiveis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarrosDisponiveisDAO {
    
    public void inserir(CarrosDisponiveis carrosDisponiveis) {

        String sql = "INSERT INTO carros_disponveis(idConcessionaria,idCarro) VALUES(?,?)";
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, carrosDisponiveis.getIdConcessionaria());
            pstm.setInt(2, carrosDisponiveis.getIdCarro());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDisponiveisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletar(CarrosDisponiveis carrosDisponiveis) {

        String sql = "DELETE FROM carrosDisponiveis WHERE idCarrosDisponiveis = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, carrosDisponiveis.getIdCarrosDisponiveis());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDisponiveisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(CarrosDisponiveis carrosDisponiveis) {

        String sql = "UPDATE carrosDisponiveis SET idConcessionaria = ?, idCarro = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, carrosDisponiveis.getIdConcessionaria());
            pstm.setInt(2, carrosDisponiveis.getIdCarro());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDisponiveisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<CarrosDisponiveis> buscar(String select,int element,int element2) throws SQLException{
      
        String sql = "SELECT * FROM carros_disponveis";
        sql = sql + select;
        
        Connection con = Conexao.getConexao();
        PreparedStatement pstm = con.prepareStatement(sql);
        ArrayList<CarrosDisponiveis> carrosDisponiveiss = new ArrayList<>();
        
        if(!select.equals("") && select != null){
            pstm.setInt(1, element);
            pstm.setInt(2, element2);
        }        
        
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            CarrosDisponiveis enc = new CarrosDisponiveis();
            enc.setIdCarrosDisponiveis(rs.getInt("idCarros_disponiveis"));
            enc.setIdCarro(rs.getInt("idCarro"));
            enc.setIdConcessionaria(rs.getInt("idConcessionaria"));
            carrosDisponiveiss.add(enc);
        }          
        return carrosDisponiveiss;        
    } 
    
}
