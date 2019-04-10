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
public class MatrizIncidencia implements Grafo {
    
    double[][] matriz = null;
    
    public MatrizIncidencia(int vertices,int arestas){
     this.matriz = new double[vertices][arestas];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < arestas; j++) {
                this.matriz[i][j] = Double.POSITIVE_INFINITY;
            }        
        }
    }
    
    @Override
    public void adicionarAresta(int origem, int destino) throws Exception{
        this.matriz[origem][destino] = 1;
    }
    
    @Override
    public void adicionarAresta(int origem, int destino, double peso) throws Exception{
        this.matriz[origem][destino] = peso;
    }
    
    @Override
    public boolean existeAresta(int origem, int destino){
        return this.matriz[origem][destino] != Double.POSITIVE_INFINITY;
    }
    
    @Override
    public int grauDoVertice(int vertice) throws Exception{
        int count = 0;
        for (int j = 0; j < this.matriz[vertice].length; j++) {
            if(this.matriz[vertice][j] != Double.POSITIVE_INFINITY)
                count++;
        }
        return count;
    }
    
    @Override
    public int numeroDeVertices(){
        return this.matriz.length;
    }
    
    @Override
    public int numeroDeArestas(){
        return this.matriz[0].length;
    }
    
    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception{
        List<Integer> list = new ArrayList<>();         
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[vertice].length; j++) {
                if(this.matriz[vertice][j] != Double.POSITIVE_INFINITY && this.matriz[i][j] != Double.POSITIVE_INFINITY)
                    list.add(i);
            }
        }
        return list;
    }
    
    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception{
        Set<Integer> list = new HashSet<>();         
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[vertice].length; j++) {
                if(this.matriz[vertice][j] != Double.POSITIVE_INFINITY && this.matriz[i][j] != Double.POSITIVE_INFINITY)
                    list.add(i);
            }
        }
            
        return list;
    }    
    
    @Override
    public void setarPeso(int origem, int destino, double peso) throws Exception{
        this.matriz[origem][destino] = peso;
    }
       
    @Override
    public Set<Integer> vertices(){
        Set<Integer> list = new HashSet<>();  
        for (int i = 0; i < this.matriz.length; i++) 
                list.add(i);
        return list;
    }
    
}
