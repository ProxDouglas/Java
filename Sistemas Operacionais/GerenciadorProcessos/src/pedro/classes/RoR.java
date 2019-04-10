package pedro.classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class RoR extends Thread {
    
    private Processador processador;
    private TelaControle telaControle;
    
    public RoR(Processador processador, TelaControle telaControle){
        this.processador = processador;
        this.telaControle = telaControle;
    }
    
    @Override
    public void run(){
        int i = 0;
        while(!processador.todosTerminados()){
            Processo temporario = processador.getProcesso(i);
            if((temporario.getTempoRestante()> processador.getQuantum()) && (temporario.getEstado() == "Pronto!")){              
                try {
                    temporario.setEstado("Executando!");
                    telaControle.mudarEstado(i, temporario);
                    temporario.setTempoRestante(temporario.getTempoRestante() - processador.getQuantum());
                    Thread.sleep(processador.getQuantum());
                    temporario.setEstado("Pronto!"); 
                    telaControle.mudarEstado(i, temporario);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RoR.class.getName()).log(Level.SEVERE, null, ex);
                }                               
            }else if((temporario.getTempoRestante() <= processador.getQuantum()) && (temporario.getEstado() == "Pronto!")) {
                try {
                    temporario.setEstado("Executando!");
                    telaControle.mudarEstado(i, temporario);
                    temporario.setEstado("Terminado!");
                    Thread.sleep(temporario.getTempoRestante());
                     temporario.setTempoRestante(0);
                    telaControle.mudarEstado(i, temporario);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RoR.class.getName()).log(Level.SEVERE, null, ex);
                }                    
            }
            i++;
            if(i > processador.tamanhoLista() - 1){
                i = 0;
            }
        }
        JOptionPane.showMessageDialog(telaControle, "EXECUÇÃO TERMINADA COM SUCESSO");
        telaControle.simulacaoTerminada();
    }
    
}
