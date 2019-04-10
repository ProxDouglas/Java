package pedro.classes;

import java.util.ArrayList;

public class Processador {
    
    public ArrayList<Processo> listaProcesso;
    private long quantum;
    public String nomeDaTecnica;
    
    public Processador(){
        listaProcesso = new ArrayList<>();
    }
    
    public void executarProcessamento(String nomeDaTecnica) throws InterruptedException{
        this.nomeDaTecnica = nomeDaTecnica;
        if(nomeDaTecnica == "FCFS"){
            tecnicaFCFS();
        }else if(nomeDaTecnica == "RoR"){
            RoR();
        }else if(nomeDaTecnica == "jobCurto"){
            jobMaisCurto();
        }else{
            System.out.println("ERRO!");
        }
    }
    
    public void adicionarProcesso(Processo processo){
        listaProcesso.add(processo);
    }
    
    public void tecnicaFCFS() throws InterruptedException{
        int i = 0;
        System.out.println("TÉCNICA FIRST COME, FIRST SERVED : ");
        System.out.println("------------------------------------------------------------");
        while(i <= (listaProcesso.size() - 1)){
            System.out.println("" + listaProcesso.get(i).getNomeProcesso() + " em execução;");
            Thread.sleep(listaProcesso.get(i).getJob());
            i++;
        }
    }
    
    public void jobMaisCurto() throws InterruptedException{
        int i,j;
        System.out.println("TÉCNICA JOB MAIS CURTO PRIMEIRO : ");
        System.out.println("-----------------------------------------------------------");
        while(listaProcesso.size() > 0){
            i = 0;
            j = 1;
            while(j <= listaProcesso.size() - 1){
                if(listaProcesso.get(i).getJob() <= listaProcesso.get(j).getJob()){
                    j++;
                }else{
                    i = j;
                    j++;
                }
            }
            System.out.println("" + listaProcesso.get(i).getNomeProcesso() + " em execução;");
            System.out.println("JOB : " + listaProcesso.get(i).getJob());
            System.out.println("---------------------------------------------------------------");
            Thread.sleep(listaProcesso.get(i).getJob());
            listaProcesso.remove(i);
        }
    }
    
    public void RoR() throws InterruptedException{
        int i = 0;
        System.out.println("TÉCNICA ROUND ROBIN - ESCALONAMENTO CIRCULAR");
        System.out.println("-----------------------------------------------------------");
        while(listaProcesso.size() > 0){
            Processo temporario = listaProcesso.get(i);
            System.out.println("" + temporario.getNomeProcesso() + " em execução;");
            if(temporario.getJob() > this.getQuantum()){
                temporario.setJob(temporario.getJob() - getQuantum());
                temporario.setEstado("Pronto para execução");
                Thread.sleep(getQuantum());
                i++;
            }else{
                temporario.setEstado("Terminado");
                System.out.println("Processo " + temporario.getNomeProcesso()+ " está : " + temporario.getEstado());
                listaProcesso.remove(i);
                Thread.sleep(temporario.getJob());
            }
            if(i > listaProcesso.size() - 1){
                i = 0;
            }
        }
    }

    
    public long getQuantum() {
        return quantum;
    }

    
    public void setQuantum(long quantum) {
        this.quantum = quantum;
    }
    
}
