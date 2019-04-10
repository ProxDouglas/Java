package classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainTeste {
    
    public static void main(String[] args) {
        Scanner linha;
        ArrayList<Rota> rotas = new ArrayList<>();
        ArrayList<Roteador> rota = new ArrayList<>();
        String ipNumero;
        String salto;
        String tempo1;
        String tempo2;
        String tempo3;
        boolean continua = false;
        
        try {
            linha = new Scanner(new FileReader("/home/matheus.flausino/redes/testeEUA.txt")).useDelimiter("\\s");
            
            while(linha.hasNext()){
                
                if("Tracing".equals(linha.next()))
                    continua = true;
                
                Rota roteiro = new Rota();
                
                while(continua){
                    for (int i = 0; i < 10; i++) {
                        linha.next();                    
                    }

                    salto = linha.next();
                    tempo1 = linha.next();
                    tempo2 = linha.next();
                    tempo3 = linha.next();
                    ipNumero = linha.next();

                    Roteador roteador = new Roteador();
                    roteador.setIpNumero(ipNumero);
                    roteador.setSalto(Integer.parseInt(salto));
                    if(!tempo1.equals("*"))
                        roteador.setTempo1(Integer.parseInt(tempo1));
                    else
                        roteador.setTempo1(-1);
                    
                    if(!tempo2.equals("*"))
                        roteador.setTempo2(Integer.parseInt(tempo2));
                    else
                        roteador.setTempo2(-1);
                    
                    if(!tempo3.equals("*"))
                        roteador.setTempo3(Integer.parseInt(tempo3));
                    else
                        roteador.setTempo3(-1);
                    
                    rota.add(roteador);
                    if(linha.next().equals("Trace")){
                        linha.next();
                        continua = false;
                    }
                    roteiro.setRota(rota);
                    rotas.add(roteiro);
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
