package pedro.classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class FCFS extends Thread {
    
    private Processador processador;
    private TelaControle telaControle;
    
    public FCFS(Processador processador, TelaControle telaControle){
        this.processador = processador;
        this.telaControle = telaControle;
    }
    
    @Override
    public void run(){
        int i = 0;
        Processo processoTemporario;
        while(!processador.todosTerminados()){
            try {
                 processoTemporario = processador.getProcesso(i);
                 processoTemporario.setEstado("Executando!");
                 telaControle.mudarEstado(i, processoTemporario);
                 Thread.sleep(processoTemporario.getJob()); 
                 processoTemporario.setEstado("Terminado!");
                 telaControle.mudarEstado(i, processoTemporario);
                 
                 i++;
            } catch (InterruptedException ex) {
                Logger.getLogger(FCFS.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        JOptionPane.showMessageDialog(telaControle, "EXECUÇÃO TERMINADA COM SUCESSO");
        telaControle.simulacaoTerminada();
    }
    
}
