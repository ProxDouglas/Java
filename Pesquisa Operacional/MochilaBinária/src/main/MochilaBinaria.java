package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MochilaBinaria {
    
    private int linhaAtual = 0;
    private double carga;
    private int n;
    private ArrayList<Integer> multiplicadores = new ArrayList<>();
    private ArrayList<Item> itens = new ArrayList<>();
    
    public void leitor(String path){
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(path));   
            carga = Double.valueOf(buffRead.readLine());
            n = Integer.valueOf(buffRead.readLine());
            String linha;
            for (int i = 0; i < n; i++) {
                linha = buffRead.readLine();
                String[] valores = linha.split("\t");
                
                Item item = new Item();
                item.setValor(Integer.parseInt(valores[0]));
                item.setPeso(Integer.parseInt(valores[1]));
                
                multiplicadores.add(new Integer(1));
                itens.add(item);                
            }            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MochilaBinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MochilaBinaria.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void executar(){
        
        int totalBits = itens.size();
        double condParada = Math.pow(2,totalBits);
        Double maiorValor = 0d;
        double valorExpr = 0;
        double valorCarga = 0;
        ArrayList<Integer> valorMaiorExp = null;             
            
        for (int i = 0; i < (int)condParada; i++) {
            for (int j = 0; j < totalBits; j++) {
                if(linhaAtual % Math.pow(2, j) == 0){
                    if((linhaAtual / Math.pow(2, j) % 2 == 0) ){
                        multiplicadores.set(j, new Integer(0));
                    }else
                        multiplicadores.set(j, new Integer(1));
                }                
            }
            for (Integer integer : multiplicadores) {
                System.out.print(integer.intValue()+ "\t");
            }
            System.out.println("");
            for (int j = 0; j < totalBits; j++) {
                valorExpr = valorExpr + (itens.get(j).getValor() * multiplicadores.get(j).intValue());
                valorCarga = valorCarga + (itens.get(j).getPeso() * multiplicadores.get(j).intValue());
            }
            if(valorExpr > maiorValor && valorCarga <= carga){
                maiorValor = valorExpr;
                valorMaiorExp = new ArrayList<>();
                for (int j = 0; j < totalBits ; j++) {
                    valorMaiorExp.add(new Integer(multiplicadores.get(j).intValue()));
                }
            }
            linhaAtual++;
            valorExpr = 0;
            valorCarga = 0;
        }
            System.out.println("----------------------");
            System.out.println("VALOR MÁXIMO ENCONTRADO = " + maiorValor);
            System.out.println("----------------------");
            System.out.println("ITENS A SEREM LEVADOS(1 levar | 0 não levar)");
            for (int i = 0; i < totalBits; i++) {
                System.out.print(valorMaiorExp.get(i).intValue());
                if(i != totalBits - 1)
                    System.out.print(" , ");
            }
            System.out.println("");

    }
    
    public static void main(String[] args) {
       MochilaBinaria mb = new MochilaBinaria();
       mb.leitor("./cont.txt");
       mb.executar();
    } 
    
    public class Item{
        
        private int valor;
        private int peso;
        
        public int getValor() {
            return valor;
        }

        public void setValor(int x) {
            this.valor = x;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int y) {
            this.peso = y;
        }        
    }
}
