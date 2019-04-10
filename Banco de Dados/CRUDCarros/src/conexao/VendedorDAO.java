package conexao;

import classes.Vendedor;
import classes.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VendedorDAO {
    
     public void inserir(Vendedor vendedor) {

        String sqlEndereco,sqlPessoa,sqlVendedor;
        Endereco endereco = vendedor.getEndereco();
        try {
            Connection con = Conexao.getConexao();
            sqlEndereco = "INSERT INTO endereco(rua,bairro,cidade,estado,pais,num) VALUES(?,?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sqlEndereco);
            pstm.setString(1, endereco.getRua());
            pstm.setString(2, endereco.getBairro());
            pstm.setString(3, endereco.getCidade());
            pstm.setString(4, endereco.getEstado());
            pstm.setString(5, endereco.getPais());
            pstm.setInt(6, endereco.getNum());
            pstm.execute();
            
            sqlPessoa = "INSERT INTO pessoa(nome,cpf,idEndereco) VALUES(?,?,?)";
            pstm = con.prepareStatement(sqlPessoa);
            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getCpf());
            pstm.setInt(3, endereco.getIdEndereco());
            pstm.execute();
            
            sqlVendedor = "INSERT INTO vendedor(idPessoa,salarioFixoMensal) VALUES(?,?)";
            pstm = con.prepareStatement(sqlVendedor);
            pstm.setInt(1, vendedor.getIdPessoa());
            pstm.setDouble(2, vendedor.getIdConcessionaria());
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletar(Vendedor vendedor) {

        String sql = "DELETE FROM vendedor WHERE idVendedor = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, vendedor.getIdVendedor());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Vendedor vendedor) {

        String sqlVendedor,sqlPessoa,sqlEndereco;
        Endereco endereco = vendedor.getEndereco();

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
            
            sqlPessoa = "UPDATE pessoa SET nome = ?,cpf = ?,endereco = ?";
            pstm = con.prepareStatement(sqlPessoa);
            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getCpf());
            pstm.setInt(3, endereco.getIdEndereco());
            pstm.execute();
            
            sqlVendedor = "UPDATE vendedor SET  idConcessionaria = ?,totalComissao = ?";
            pstm = con.prepareStatement(sqlVendedor);
            pstm.setInt(1, vendedor.getIdConcessionaria());
            pstm.setDouble(2, vendedor.getTotalComissao());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Vendedor> buscar(String select,String element) throws SQLException{
      
        String sql = "SELECT * FROM vendedor v,pessoa p,endereco e WHERE v.idPessoa = p.idPessoa AND "
                + "p.idEndereco = e.idEndereco"; 
        
        sql = sql + select;
        
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        PreparedStatement pstm = con.prepareStatement(sql); 
        System.out.println(sql);
        System.out.println(element);
        
        if(!select.equals("") && select != null){
            pstm.setString(1, element);
        }
        
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Vendedor ven = new Vendedor();
            Endereco end = new Endereco();
            ven.setIdVendedor(rs.getInt("v.idVendedor"));
            ven.setTotalComissao(rs.getDouble("v.totalComissao"));
            ven.setIdConcessionaria(rs.getInt("v.idConcessionaria"));
            ven.setNome(rs.getString("p.nome"));
            ven.setIdPessoa(rs.getInt("p.idPessoa"));
            ven.setCpf(rs.getString("p.cpf"));
            end.setRua(rs.getString("e.rua"));
            end.setBairro(rs.getString("e.bairro"));
            end.setCidade(rs.getString("e.cidade"));
            end.setEstado(rs.getString("e.estado"));
            end.setPais(rs.getString("e.pais"));
            end.setNum(rs.getInt("e.num"));
            end.setIdEndereco(rs.getInt("e.idEndereco"));
            ven.setEndereco(end);
            vendedores.add(ven);
        }  
        
        return vendedores;        
    }    
}
