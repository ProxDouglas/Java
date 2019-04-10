/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeradorDeMatrizParaOGrafico {

    public static void main(String[] args) {
        BufferedReader br = null;
        int matrizResultado[][] = new int[8][8];
        int cont1col = 0, cont2col = 0, cont3col = 0, cont4col = 0, cont5col = 0, cont6col = 0, cont7col = 0;
        String[] arrayTitulos = {"0.00-0.10", "0.10-0.25", "0.25-0.50", "0.50-1.00", "1.00-1.50", "1.50-***", "Impossível_Calcular", "TOTAL"};
        try {
            br = new BufferedReader(new FileReader("arquivoResultados.txt"));
            String linha;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 100; j++) {
                    linha = br.readLine();
                    if (linha.equals("NÃO FOI POSSÍVEL CALCULAR")) {
                        cont7col++;
                    } else {
                        double valor = Double.parseDouble(linha);
                        if (valor < 0.1) {
                            cont1col++;
                        } else if (valor < 0.25) {
                            cont2col++;
                        } else if (valor < 0.5) {
                            cont3col++;
                        } else if (valor < 1.0) {
                            cont4col++;
                        } else if (valor < 1.5) {
                            cont5col++;
                        } else {
                            cont6col++;
                        }
                    }
                }
                matrizResultado[i][0] = cont1col;
                matrizResultado[i][1] = cont2col;
                matrizResultado[i][2] = cont3col;
                matrizResultado[i][3] = cont4col;
                matrizResultado[i][4] = cont5col;
                matrizResultado[i][5] = cont6col;
                matrizResultado[i][6] = cont7col;
                matrizResultado[i][7] = 100;
                
                cont1col = cont2col = cont3col = cont4col = cont5col = cont6col = cont7col =  0;
                
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("arquivoMatrizGrafico.txt"));

            bw.append("Cenarios ");
            bw.flush();

            for (int i = 0; i < arrayTitulos.length; i++) {
                bw.append(arrayTitulos[i] + " ");
                bw.flush();
            }
            
            bw.newLine();
            bw.flush();
            
            for (int i = 0; i < 8; i++) {
                bw.append("Cenario_" +i+ "\t");
                for (int j = 0; j < 8; j++) {
                    bw.append(matrizResultado[i][j] + "\t");
                    bw.flush();
                }
                bw.newLine();
                bw.flush();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeradorDeMatrizParaOGrafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeradorDeMatrizParaOGrafico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GeradorDeMatrizParaOGrafico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
