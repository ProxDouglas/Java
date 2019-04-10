package pedro.classes;

import java.util.ArrayList;

public class Processador {
    
    private ArrayList<Processo> listaProcesso;
    private long quantum;
    private String nomeDaTecnica;
    private TelaControle tela;
    
    public Processador(TelaControle tela){
        listaProcesso = new ArrayList<>();
        this.tela = tela;
    }
    
    public void executarProcessamento(String nomeDaTecnica) throws InterruptedException{
        this.nomeDaTecnica = nomeDaTecnica;
        if("FCFS".equals(nomeDaTecnica)){
            new FCFS(this,tela).start();
        }else if("RoR".equals(nomeDaTecnica)){
            new RoR(this,tela).start();
        }else if("jobCurto".equals(nomeDaTecnica)){
            new JobCurto(this,tela).start();
        }else{
            System.out.println("ERRO!");
        }
    }
    
    public void adicionarProcesso(Processo processo){
        listaProcesso.add(processo);
    }
    
    public long getQuantum() {
        return quantum;
    }

    
    public void setQuantum(long quantum) {
        this.quantum = quantum;
    }
    
    public int tamanhoLista(){
        return listaProcesso.size();
    }

    public boolean todosTerminados() {
       int i = 0;
       while(i < listaProcesso.size()){
          if("Terminado!".equals(listaProcesso.get(i).getEstado())){
              i++;
          }
          else{
              return false;
          }
       }
       return true;        
    }  
    
    public Processo getProcesso(int i){
        return listaProcesso.get(i);
    }
    
    public void apagaLista(){
        this.listaProcesso.clear();
    }
    
    public void apagaElemento(int i){
        this.listaProcesso.remove(i);
    }
}
