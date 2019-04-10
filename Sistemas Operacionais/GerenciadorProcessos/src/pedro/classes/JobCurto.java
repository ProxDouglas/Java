package pedro.classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class JobCurto extends Thread{
    
    private Processador processador;
    private TelaControle telaControle;
    
    public JobCurto(Processador processador, TelaControle telaControle){
        this.processador = processador;
        this.telaControle = telaControle;
    }
    
    @Override
    public void run(){
        int i,j;
        Processo temporario;
        while(!processador.todosTerminados()){
            i = 0;
            j = 1;
            while(j <= processador.tamanhoLista() - 1){
                if(processador.getProcesso(i).getEstado().equals("Terminado!") ){
                    i++;
                    j++;
                }
                else if(processador.getProcesso(j).getEstado().equals("Terminado!")){
                    j++;
                }    
                else if((processador.getProcesso(i).getJob() <= processador.getProcesso(j).getJob())&&
                          !"Terminado!".equals(processador.getProcesso(i).getEstado()) &&
                              !"Terminado!".equals(processador.getProcesso(j).getEstado())){
                    j++;
                }else{
                    i = j;
                    j++;
                }
            }
            try {
                  temporario = processador.getProcesso(i);
                  temporario.setEstado("Executando!");
                  telaControle.mudarEstado(i,temporario);
                  Thread.sleep(temporario.getJob());
                  temporario.setEstado("Terminado!");
                  telaControle.mudarEstado(i,temporario);
            } catch (InterruptedException ex) {
                Logger.getLogger(JobCurto.class.getName()).log(Level.SEVERE, null, ex);
            }                 
     }
        JOptionPane.showMessageDialog(telaControle, "EXECUÇÃO TERMINADA COM SUCESSO");
        telaControle.simulacaoTerminada();
    }
    
}
