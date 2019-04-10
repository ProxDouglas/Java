package conexao;

import classes.Concessionaria;
import classes.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConcessionariaDAO {
    
     public void inserir(Concessionaria concessionaria) {

        String sqlEndereco,sqlConcessionaria;
        Endereco endereco = concessionaria.getEndereco();
        try {
            sqlEndereco = "INSERT INTO endereco(rua,bairro,cidade,estado,pais,num) VALUES(?,?,?,?,?,?)";
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sqlEndereco);
            pstm.setString(1, endereco.getRua());
            pstm.setString(2, endereco.getBairro());
            pstm.setString(3, endereco.getCidade());
            pstm.setString(4, endereco.getEstado());
            pstm.setString(5, endereco.getPais());
            pstm.setInt(6, endereco.getNum());
            pstm.execute();
            
            sqlConcessionaria = "INSERT INTO concessionaria(nome,idEndereco) VALUES(?,?)";
            pstm = con.prepareStatement(sqlConcessionaria);
            pstm.setString(1, concessionaria.getNome());
            pstm.setInt(2, endereco.getIdEndereco());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConcessionariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletar(Concessionaria concessionaria) {

        String sql = "DELETE FROM concessionaria WHERE idConcessionaria = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, concessionaria.getIdConcessionaria());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConcessionariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Concessionaria concessionaria) {

        String sqlEndereco,sqlConcessionaria ;
        Endereco endereco = concessionaria.getEndereco();
        
        try {
            Connection con = Conexao.getConexao();
            sqlEndereco = "UPDATE endereco SET rua = ?,bairro = ?, cidade = ?, estado = ?, pais = ?, num = ?"
                    + " WHERE idEndereco = ?";
            PreparedStatement pstm = con.prepareStatement(sqlEndereco);
            pstm.setString(1, endereco.getRua());
            pstm.setString(2, endereco.getBairro());
            pstm.setString(3, endereco.getCidade());
            pstm.setString(4, endereco.getEstado());
            pstm.setString(5, endereco.getPais());
            pstm.setInt(6, endereco.getNum());
            pstm.setInt(7, endereco.getIdEndereco());
            pstm.execute();
            
            sqlConcessionaria = "UPDATE concessionaria SET nome = ?";
            pstm = con.prepareStatement(sqlConcessionaria);
            pstm.setString(1, concessionaria.getNome());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConcessionariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Concessionaria> buscar(String select,String element) throws SQLException{
      
        String sql = "SELECT * FROM concessionaria c,endereco e WHERE c.idEndereco = e.idEndereco";
        sql = sql + select;
        
        Connection con = Conexao.getConexao();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        if(!select.equals("") && select != null){
            pstm.setString(1, element);
        }
        
        ArrayList<Concessionaria> concessionarias = new ArrayList<>();
               
        ResultSet rs = pstm.executeQuery();
        if(!rs.next())
            System.out.println("ERRO!");
        while(rs.next()){
            Concessionaria car = new Concessionaria();
            Endereco end = new Endereco();
            car.setIdConcessionaria(rs.getInt("c.idConcessionaria"));
            car.setNome(rs.getString("c.nome"));
            end.setRua(rs.getString("e.rua"));
            end.setBairro(rs.getString("e.bairro"));
            end.setCidade(rs.getString("e.cidade"));
            end.setEstado(rs.getString("e.estado"));
            end.setPais(rs.getString("e.pais"));
            end.setIdEndereco(rs.getInt("e.idEndereco"));
            end.setNum(rs.getInt("e.num"));
            car.setEndereco(end);
            concessionarias.add(car);
        }  
        
        return concessionarias;        
    }
    
}
