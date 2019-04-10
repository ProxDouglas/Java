package classes;


public class Concessionaria{
    
    private int idConcessionaria;
    private String nome;
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getIdConcessionaria() {
        return idConcessionaria;
    }

    public void setIdConcessionaria(int idConcessionaria) {
        this.idConcessionaria = idConcessionaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
