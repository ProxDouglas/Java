package simulacao;


public class Cliente {
    
    private String nome;
    private double tempoChegada;
    private double tempoSaída;
    
    public double getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(double tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public double getTempoSaída() {
        return tempoSaída;
    }

    public void setTempoSaída(double tempoSaída) {
        this.tempoSaída = tempoSaída;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    } 
    
}
