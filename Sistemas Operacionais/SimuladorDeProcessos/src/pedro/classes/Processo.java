package pedro.classes;

public class Processo {
    
    private String nomeProcesso;
    private long job;
    private String estado;
    
    public Processo(String nomeProcesso,long job){
        this.nomeProcesso = nomeProcesso;
        this.job = job;
    }
    
   
    public String getNomeProcesso() {
        return nomeProcesso;
    }

    
    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    
    public long getJob() {
        return job;
    }

    
    public void setJob(long job) {
        this.job = job;
    }

  
    public String getEstado() {
        return estado;
    }

   
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
