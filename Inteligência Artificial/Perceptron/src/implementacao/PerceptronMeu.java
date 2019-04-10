package implementacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerceptronMeu {
    
    private int[][] entradas = new int[100][100];
    private int linhasEntrada,colunasEntrada;
    private int[] saidasEsperadas = new int[3];
    private double[] pesos = new double[4];
    private double alfaAprendizado;
    private int max_iteracoes;
    private double bias = -1;
    
    public PerceptronMeu(double alfaAprendizado,int max_iteracoes){
        this.alfaAprendizado = alfaAprendizado;
        this.max_iteracoes = max_iteracoes;
    }
    
    public void leitor(String path) {
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(new FileReader(path));
            String linha;
            while (true) {
                linha = buffRead.readLine();
                if(linha != null){
                    String[] elementos = linha.split("\t");
                    for (int i = 0; i < elementos.length - 1; i++) {
                        entradas[linhasEntrada][i] = Integer.parseInt(elementos[i]);
                    }                    
                    saidasEsperadas[linhasEntrada] = Integer.parseInt(elementos[elementos.length - 1]);
                    linhasEntrada++;
                    colunasEntrada = elementos.length - 1;
                }else{
                    break;
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PerceptronMeu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PerceptronMeu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffRead.close();
            } catch (IOException ex) {
                Logger.getLogger(PerceptronMeu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    public void ajustarPesos(){
        int t = 1;
        boolean sair;
        double y = 0,erro = 0;
        do{
            sair = true;
            for (int i = 0; i < linhasEntrada; i++) {
                for (int j = 0; j < colunasEntrada; j++) {
                   y = y + (entradas[i][j] * pesos[j]); 
                }
                y += (bias * pesos[colunasEntrada]);
                
                if(y > 0)
                    y = 1;
                else
                    y = 0;
                
                if(saidasEsperadas[i] != y){
                    erro = (saidasEsperadas[i] - y);
                    calibrar(erro, i);
                    sair = false;
                }
            }
            t++;
        }while((t < max_iteracoes) && (!sair));
        
        System.out.println("treinou " + t + " vezes!");        
        
        if(t < max_iteracoes){
            for (int i = 0; i < linhasEntrada; i++) {
               for (int j = 0; j < colunasEntrada; j++) {
                  y = y + (0 * pesos[j]); 
               }
            }
            y += (bias * pesos[colunasEntrada]);
            if(y > 0)
                y = 1;
            else
                y = 0;
            System.out.println(" y = " + y);
            System.out.println("");
        }        
    }
    
    public void calibrar(double erro, int posicao){
        for (int i = 0; i < colunasEntrada; i++) {
            pesos[i] = pesos[i] + (alfaAprendizado * erro * entradas[posicao][i]);
        }
        pesos[colunasEntrada] = pesos[colunasEntrada] + (alfaAprendizado * erro * bias);
    }
    
    public static void main(String[] args) {
        PerceptronMeu pm = new PerceptronMeu(0.2, 100);
        pm.leitor("./conf.txt");
        pm.ajustarPesos();
    }
}
