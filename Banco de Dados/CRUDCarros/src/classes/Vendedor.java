package classes;


public class Vendedor extends Pessoa{
    
    private int idVendedor;
    private int idConcessionaria;
    private double totalComissao;

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdConcessionaria() {
        return idConcessionaria;
    }

    public void setIdConcessionaria(int idConcessionaria) {
        this.idConcessionaria = idConcessionaria;
    }

    public double getTotalComissao() {
        return totalComissao;
    }

    public void setTotalComissao(double totalComissao) {
        this.totalComissao = totalComissao;
    }    
}
