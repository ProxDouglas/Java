/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;


import grafos.Grafo;
import java.util.*;
/**
 *
 * @author Pedro
 */
public class ListaAdjacencia implements Grafo {
    
    Lista[] lista = null;

    public ListaAdjacencia(int vertices) {
        this.lista = new Lista[vertices];
        for (int i = 0; i < vertices; i++) {
            this.lista[i] = new Lista(i);
        }
    }    

    @Override
    public void adicionarAresta(int origem, int destino) throws Exception {
         int i = origem;
         Lista test = lista[i];
         while(test.aresta != null){
             test = test.aresta;
         }
         if(i != destino)
            test = new Lista(destino);
    }

    @Override
    public void adicionarAresta(int origem, int destino, double peso) throws Exception {
        int i = origem;
        Lista test = lista[i];
         while(test.aresta != null){
             test = test.aresta;
         }
         if(i != destino)
            test = new Lista(destino, peso);
    }

    @Override
    public boolean existeAresta(int origem, int destino) { 
        int i = origem;
        Lista test = lista[i];
        while(test.aresta != null){
            if(i == destino)
                return true;
            i = test.aresta.indice;
        }
        return false;
    }

    @Override
    public int grauDoVertice(int vertice) throws Exception {
        int i = vertice;
         Lista test = lista[i];
        int count = 0;
        while(test.aresta != null){
            count++;
            i = test.aresta.indice;
        }
        return count;
    }

    @Override
    public int numeroDeVertices() {
        return this.lista.length;
    }

    @Override
    public int numeroDeArestas() {
        int count = 0;
        int i = 0;
        Lista test = lista[i];
        for (int l = 0; l < this.lista.length; l++) {
            while(test.aresta != null){
                count++;
                i = test.aresta.indice;
            }
        }
        return count;
    }

    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception {
        List<Integer> list = new ArrayList<>();         
        int i = vertice;
        while(this.lista[i].aresta != null){
            list.add(this.lista[i].aresta.indice);
            i = this.lista[i].aresta.indice;
        }
        return list;
    }

    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception {
        Set<Integer> list = new HashSet<>();         
        int i = vertice;
         Lista test = lista[i];
        while(test.aresta != null){
            list.add(test.aresta.indice);
            i = test.aresta.indice;
        }
        return list;
    }

    @Override
    public void setarPeso(int origem, int destino, double peso) throws Exception {
        int i = origem;
        Lista test = lista[i];
        while(test.aresta != null && i != destino)
            i = test.aresta.indice;
        if(i == destino)
           test.aresta.peso = peso;     
    }

    @Override
    public Set<Integer> vertices() {
        Set<Integer> list = new HashSet<>();  
        for (int i = 0; i < this.lista.length; i++) 
                list.add(i);
        return list;
    }
    
}
