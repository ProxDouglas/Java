package simulacao;

import java.util.ArrayList;
import java.util.List;

public class Simulacao {
    
    public static double aleatorio(){
        double d = Math.random();
        return 1.0-d;
    }
   
    public static void main(String[] args) {
        
        double lCliente = 0.2;
        double lCaixa = 1/4.5;
        
        double tempoSimulacao = 0;
        double tempoChegada = 0.0;
        double tempoAtendimento = 0.0;
        
        double tempoChegadaAnterior;
               
        double somatorioTempoChegadaEW = 0.0;
        double somatorioTempoAtendimentoEW = 0.0;
        
        double somatorioDaUtilizacao = 0.0; 
        double somatorioDasAreas = 0.0;
        double tempoAnterior;
        
        int contadorSaidaCliente = 0;
        int contadorCliente = 0;     
        
        
        List<Cliente> filaDeClientes = new ArrayList<>();
        
        do{
            
            tempoAnterior = tempoSimulacao;
            
            if(tempoAtendimento > 0.0)
                tempoSimulacao = Math.min(tempoChegada, tempoAtendimento);
            else
                tempoSimulacao = tempoChegada;
            
            if(!filaDeClientes.isEmpty())
                    somatorioDaUtilizacao = somatorioDaUtilizacao + (tempoSimulacao - tempoAnterior);
            
            somatorioDasAreas = somatorioDasAreas + ((tempoSimulacao - tempoAnterior) * filaDeClientes.size());
            
            if(tempoSimulacao == tempoChegada){                             
                
                tempoChegadaAnterior = tempoChegada;
                
                Cliente cliente = new Cliente();
                cliente.setNome("Cliente " + contadorCliente);
                filaDeClientes.add(cliente);
                
                if(tempoAtendimento == 0.0){        
                    tempoAtendimento = tempoSimulacao + (-1.0 / lCaixa) * Math.log(aleatorio());                    
                }
                                
                tempoChegada = tempoSimulacao + (-1.0 / lCliente) * Math.log(aleatorio());
                
                cliente.setTempoChegada(tempoChegada);
                contadorCliente++;
                
            }else{  
                
                                
                Cliente cliente = filaDeClientes.remove(0);
                somatorioTempoAtendimentoEW = somatorioTempoAtendimentoEW + (tempoAtendimento - cliente.getTempoChegada());
                
                
                if(filaDeClientes.isEmpty())
                    tempoAtendimento = 0.0;
                else{
                    tempoAtendimento = tempoSimulacao + (-1.0 / lCaixa) * Math.log(aleatorio());
                }
                         
                contadorSaidaCliente++;
            }           
            
        }while(tempoSimulacao <= 1000000);
        System.out.println("LAMBDA");
        System.out.println(contadorCliente/tempoSimulacao);
        System.out.println("-------------------------------------------------");
        System.out.println("E[W]");
        System.out.println(somatorioTempoAtendimentoEW/contadorSaidaCliente);
        System.out.println("-------------------------------------------------");
        System.out.println("E[N]");
        System.out.println(somatorioDasAreas/tempoSimulacao);
        System.out.println("-------------------------------------------------");
        System.out.println("TAXA DE UTILIZAÇÃO");
        System.out.println(somatorioDaUtilizacao/tempoSimulacao * 100 + "% de utlização.");
        System.out.println("-------------------------------------------------");
        System.out.println("DIFERENÇA");
        System.out.println((somatorioDasAreas/tempoSimulacao) - ((contadorCliente/tempoSimulacao) * (somatorioTempoAtendimentoEW/contadorSaidaCliente)));
    }
}
