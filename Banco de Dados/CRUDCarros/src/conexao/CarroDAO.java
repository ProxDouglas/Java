package conexao;

import classes.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroDAO {

    public void inserir(Carro carro) {

        String sql = "INSERT INTO carro(idFabricante,tipo_Combustivel,modelo,cor,max_Velo,potencia"
                + ",preco) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, carro.getIdFabricante());
            pstm.setString(2, carro.getTipo_Combustivel());
            pstm.setString(3, carro.getModelo());
            pstm.setString(4, carro.getCor());
            pstm.setDouble(5, carro.getMax_Velo());
            pstm.setInt(6, carro.getPotencia());
            pstm.setDouble(7, carro.getPreco());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletar(Carro carro) {

        String sql = "DELETE FROM carro WHERE idCarro = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, carro.getIdCarro());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Carro carro) {

        String sql = "UPDATE carro SET idFabricante = ? , tipo_Combustivel = ?, modelo = ?, cor = ? ,"
                + " max_Velo = ?,preco = ?, potencia = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, carro.getIdFabricante());
            pstm.setString(2, carro.getTipo_Combustivel());
            pstm.setString(3, carro.getModelo());
            pstm.setString(4, carro.getCor());
            pstm.setDouble(5, carro.getMax_Velo());
            pstm.setDouble(6, carro.getPreco());
            pstm.setInt(7, carro.getPotencia());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Carro> buscar(String select,String element) throws SQLException{
      
        String sql = "SELECT * FROM carro";
        sql = sql + select;
        
        Connection con = Conexao.getConexao();
        PreparedStatement pstm = con.prepareStatement(sql);
        ArrayList<Carro> carros = new ArrayList<>();
        
        if(select != null){
            pstm.setString(1, element);
        }        
        
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Carro car = new Carro();
            car.setIdCarro(rs.getInt("idCarro"));
            car.setIdFabricante(rs.getInt("idFabricante"));
            car.setCor(rs.getString("cor"));
            car.setMax_Velo(rs.getDouble("max_Velo"));
            car.setModelo(rs.getString("modelo"));
            car.setPotencia(rs.getInt("potencia"));
            car.setTipo_Combustivel(rs.getString("tipo_Combustivel"));
            car.setPreco(rs.getDouble("preco"));
            car.setUrl(rs.getString("url"));
            carros.add(car);
        }  
        
        return carros;        
    }    
}
