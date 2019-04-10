/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import grafos.Grafo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public class DFS {

    public int tempo;
    public Map<Integer, Cor> v = new HashMap<>();
    public Map<Integer, Integer> d = new HashMap<>(); //vertice,tempo
    public Map<Integer, Integer> f = new HashMap<>(); //vertice,tempo
    Grafo g;
    
    public DFS(Grafo gr, List<Integer> ordeDeVisita) throws Exception {
          for (int i = 0; i < gr.numeroDeVertices(); i++) {
            ordeDeVisita.add(i);
          }
          tempo = 0;
          this.g = gr;
          for (int i = 0; i < ordeDeVisita.size(); i++) {
             v.put(ordeDeVisita.get(i), Cor.BRANCO);
          }
          int j = 0;
          int l = 0;
          for (int i = 0; i < ordeDeVisita.size(); i++) {
              j = ordeDeVisita.get(i);
              if(v.get(j) == Cor.BRANCO)
                  DFSVisit(j);
          }
         System.out.println("\n");
         System.out.println("Resultados: ");
         System.out.println(v);
         System.out.println("Tempo de descoberta: " + d);
         System.out.println("Tempo de finalização: " + f);
         System.out.println("TOTAL: " + tempo);
    }
    
    public void DFSVisit(int i) throws Exception{

        v.replace(i, Cor.CINZA);
        tempo++;
        d.put(i, tempo);
        for (int k = 0; k < g.conjuntoDeAdjacentes(i).size(); k++) {
            int l = g.listDeAdjacentes(i).get(k);
            if(v.get(l) == Cor.BRANCO)
                DFSVisit(l);
        }
        v.replace(i, Cor.PRETO);
        f.put(i, tempo);
        tempo++;
    }
    
}
