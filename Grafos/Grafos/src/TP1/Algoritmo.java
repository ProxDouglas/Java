/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import grafos.Grafo;
import grafos.ResultadoBuscaProfundidade;
import grafos.TipoDeRepresentacao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Pedro
 */
public class Algoritmo implements grafos.AlgoritmosEmGrafos {

    public Algoritmo() {
    }

    
    @Override
    public Grafo carregarGrafo(String path, TipoDeRepresentacao t) throws Exception {
        Grafo g = null;
        Scanner ler = new Scanner(System.in);
        String str[];
        int count = 0;
        try{            
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            linha = lerArq.readLine();
            int vertices = Integer.parseInt(lerArq.readLine());
            System.out.println("vertices = " + vertices);
            linha = lerArq.readLine();
            int arestas = Integer.parseInt(lerArq.readLine());
            System.out.println("arestas = " + arestas);
              switch(t){
                case MATRIZ_DE_ADJACENCIA:
                    g = new MatrizAdjacencia(vertices);
                    break;
                case MATRIZ_DE_INCIDENCIA:
                    g = new MatrizIncidencia(vertices, arestas);
                    break;
                case LISTA_DE_ADJACENCIA:
                    g = new ListaAdjacencia(vertices);
                    break;
            }
            while((linha = lerArq.readLine()) != null){   
                str = linha.split("\t");          
                g.adicionarAresta(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Double.parseDouble(str[2])); 
            }           
        }catch (IOException ex) {}
        return g;
    }

    @Override
    public ResultadoBuscaProfundidade buscaEmProfundidade(Grafo g, List<Integer> ordeDeVisita) {
        try {
            DFS busca = new DFS(g, ordeDeVisita);
        } catch (Exception ex) {
            Logger.getLogger(Algoritmo.class.getName()).log(Level.SEVERE, null, ex);
        }
          return null;
    }
    
    
}