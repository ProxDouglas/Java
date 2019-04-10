/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection con = null;
    private Conexao(){
        
    }
    
    public static Connection getConexao(){
        if(con != null){
            return con;
        }
        con = conectar();
        return con;
    }
    
    public static Connection conectar() {
        Connection connection = null; //atributo do tipo Connection 
        try { // Carregando o JDBC Driver padrão 
            String driverName = "com.mysql.jdbc.Driver"; 
            Class.forName(driverName); // Configurando a nossa conexão com um banco de dados//
            String serverName = "200.131.224.101"; //caminho do servidor do BD 
            String mydatabase ="matheusd"; //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "matheusd"; //nome de um usuário de seu BD 
            String password = "matheusd"; //sua senha de acesso
            connection = (Connection) DriverManager.getConnection(url, username, password); 
            if (connection != null) { 
                System.out.println("STATUS--->Conectado com sucesso!");
            } 
            else { 
                System.out.println("STATUS--->Não foi possivel realizar conexão");
            } 
            return connection;
        } 
        catch (ClassNotFoundException e) { //Driver não encontrado 
           System.out.println("O driver expecificado nao foi encontrado."); 
          return null;
        } catch (SQLException e) { //Não conseguindo se conectar ao banco 
          System.out.println("Nao foi possivel conectar ao Banco de Dados."); 
          return null; 
        } 
    }       
    
    public static void main(String[] args) {
        conectar();
    }
}
