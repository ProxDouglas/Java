package conexao;

import classes.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VendaDAO {

    public void inserir(Venda venda) {

        String sql = "INSERT INTO venda(idCliente,idConcessionaria,valorTotal,tipoPagamento,"
                + "idVendedor,data_venda,idCarro) VALUES(?,?,?,?,?,?,?)";
        try {
            System.out.println(venda.getIdCarro() + " carro");
            System.out.println(venda.getIdCliente() + " cliente");
            System.out.println(venda.getIdVenda() + " venda");
            System.out.println(venda.getIdConcessionaria() + " concessionaria");               
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, venda.getIdCliente());
            pstm.setInt(2, venda.getIdConcessionaria());
            pstm.setDouble(3, venda.getValorTotal());
            pstm.setString(4, venda.getTipoPagamento());
            pstm.setInt(5, venda.getIdVendedor());
            pstm.setDate(6, venda.getData_venda());
            pstm.setInt(7, venda.getIdCarro());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletar(Venda venda) {

        String sql = "DELETE FROM venda WHERE idVenda = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, venda.getIdVenda());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Venda venda) {

        String sql = "UPDATE venda SET idCliente = ? , idConcessionaria = ?, idVendedor = ?, idCarro = ? ,"
                + " valorTotal = ?,tipoPagamento = ?, data_venda = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, venda.getIdCliente());
            pstm.setInt(2, venda.getIdConcessionaria());
            pstm.setInt(3, venda.getIdVendedor());
            pstm.setInt(4, venda.getIdCarro());
            pstm.setDouble(5, venda.getValorTotal());
            pstm.setString(6, venda.getTipoPagamento());
            pstm.setDate(7, venda.getData_venda());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Venda> buscar(String select,String element) throws SQLException{
      
        String sql = "SELECT * FROM venda";
        sql = sql + select;
        
        Connection con = Conexao.getConexao();
        PreparedStatement pstm = con.prepareStatement(sql);
        ArrayList<Venda> vendas = new ArrayList<>();
        
        if(select != null){
            pstm.setString(1, element);
        }        
        
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Venda ven = new Venda();
            ven.setIdVenda(rs.getInt("idVenda"));
            ven.setIdCarro(rs.getInt("idCarro"));
            ven.setIdCliente(rs.getInt("idCliente"));
            ven.setIdConcessionaria(rs.getInt("idConcessionaria"));
            ven.setData_venda(rs.getDate("data_venda"));
            ven.setTipoPagamento(rs.getString("tipoPagamento"));
            ven.setValorTotal(rs.getDouble("valorTotal"));
            ven.setIdVendedor(rs.getInt("idVendedor"));
            vendas.add(ven);
        }          
        return vendas;        
    }    
    
    
}
