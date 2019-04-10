package conexao;


import classes.Cliente;
import classes.Endereco;
import filtros.EnderecoFiltro;
import filtros.PessoaFiltro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO {
    private EnderecoFiltro enderecoFiltro;
    private PessoaFiltro pessoaFiltro;
    
    public ClienteDAO(){
        this.enderecoFiltro = new EnderecoFiltro();
        this.pessoaFiltro = new PessoaFiltro();
    }
    
     public void inserir(Cliente cliente) {

        String sqlEndereco,sqlPessoa,sqlCliente;
        Endereco endereco = cliente.getEndereco();
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
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            endereco.setIdEndereco(enderecoFiltro.buscarIdEndereco(endereco));
            pstm.setInt(3, endereco.getIdEndereco());
            pstm.execute();
            
            sqlCliente = "INSERT INTO cliente(idPessoa,salarioFixoMensal) VALUES(?,?)";
            pstm = con.prepareStatement(sqlCliente);
            cliente.setIdPessoa(pessoaFiltro.buscarIdPessoa(cliente.getCpf()));
            pstm.setInt(1, cliente.getIdPessoa());
            pstm.setDouble(2, cliente.getSalarioFixoMensal());
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletar(Cliente cliente) {

        String sql = "DELETE FROM cliente WHERE idCliente = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, cliente.getIdCliente());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Cliente cliente) {

        String sqlCliente,sqlPessoa,sqlEndereco;
        Endereco endereco = cliente.getEndereco();

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
            
            sqlPessoa = "UPDATE pessoa SET nome = ?,cpf = ? WHERE idPessoa = ?";
            pstm = con.prepareStatement(sqlPessoa);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setInt(3, cliente.getIdPessoa());
            pstm.execute();
            
            sqlCliente = "UPDATE cliente SET  salarioFixoMensal = ? WHERE idCliente = ?";
            pstm = con.prepareStatement(sqlCliente);
            pstm.setDouble(1, cliente.getSalarioFixoMensal());
            pstm.setInt(2, cliente.getIdCliente());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Cliente> buscar(String select,String element) throws SQLException{
      
        String sql = "SELECT * FROM cliente c,pessoa p,endereco e WHERE c.idPessoa = p.idPessoa AND "
                + "p.idEndereco = e.idEndereco"; 
        
        sql = sql + select;
        element = "%"+element+"%";
                
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        System.out.println(sql);
        System.out.println(element);
        PreparedStatement pstm = con.prepareStatement(sql);
        if(!select.equals("")){
            pstm.setString(1, element);
        }
        
        ResultSet rs = pstm.executeQuery();
        if(!rs.next())
            System.out.println("ERRO!");
        while(rs.next()){
            Cliente cli = new Cliente();
            Endereco end = new Endereco();
            cli.setIdCliente(rs.getInt("c.idCliente"));
            cli.setSalarioFixoMensal(rs.getDouble("c.salarioFixoMensal"));
            cli.setNome(rs.getString("p.nome"));
            cli.setIdPessoa(rs.getInt("p.idPessoa"));
            cli.setCpf(rs.getString("p.cpf"));
            end.setRua(rs.getString("e.rua"));
            end.setBairro(rs.getString("e.bairro"));
            end.setCidade(rs.getString("e.cidade"));
            end.setEstado(rs.getString("e.estado"));
            end.setPais(rs.getString("e.pais"));
            end.setNum(rs.getInt("e.num"));
            end.setIdEndereco(rs.getInt("e.idEndereco"));
            cli.setEndereco(end);
            clientes.add(cli);
        }  
        
        return clientes;        
    }   
}
