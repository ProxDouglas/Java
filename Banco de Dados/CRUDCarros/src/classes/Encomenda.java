package classes;

import java.sql.Date;


public class Encomenda {
    
    private int idEncomenda;
    private int idConcessionaria;
    private int idCliente;
    private int idCarro;
    private Date data_Entrega;

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public int getIdConcessionaria() {
        return idConcessionaria;
    }

    public void setIdConcessionaria(int idConcessionaria) {
        this.idConcessionaria = idConcessionaria;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public Date getData_Entrega() {
        return data_Entrega;
    }

    public void setData_Entrega(Date data_Entrega) {
        this.data_Entrega = data_Entrega;
    }
    
    
    
    
}
