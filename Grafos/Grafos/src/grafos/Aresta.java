/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author HumbertoBrandão
 */
public class Aresta {
    int origem;
    int destino;
    
    public Aresta(int origem, int destino){
        this.origem = origem;
        this.destino = destino;
    }
    
    public int getOrigem(){
        return this.origem;
    }
    
    public int getDestino(){
        return this.destino;
    }
}
