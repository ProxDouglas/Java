/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

/**
 *
 * @author Pedro
 */
public class Lista {
    
    public int indice;
    public double peso;
    public Lista aresta;
    
    public Lista(int indice, double peso) {
        this.peso = peso;
        this.indice = indice;
        this.aresta = null;
    }
    
    public Lista(int indice) {
        this.aresta = null;
        this.peso = Double.POSITIVE_INFINITY;
    }
    
    
    
}
