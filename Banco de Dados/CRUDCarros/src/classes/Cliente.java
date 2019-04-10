package classes;


public class Cliente extends Pessoa{
    
    private int idCliente;
    private double salarioFixoMensal;
   

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getSalarioFixoMensal() {
        return salarioFixoMensal;
    }

    public void setSalarioFixoMensal(double salarioFixoMensal) {
        this.salarioFixoMensal = salarioFixoMensal;
    }    
}
