package implementacao;

import java.util.Random;

public class Individuo {

    private boolean genetica[];
    private Random r;

    public Individuo(int tamanhoGenes) {
        genetica = new boolean[tamanhoGenes];
        r = new Random();
        gerarGenetica();
    }
    
    private void gerarGenetica(){
        for (int i = 0; i < genetica.length; i++) {
            genetica[i] = r.nextBoolean();
        }
    }
    
    public void allZeros(){
        for (int i = 0; i < genetica.length; i++) {
            genetica[i]=false;
        }
    }

    public double getAptidao() {
        double aptidao = 0;
        for (int i = 0; i < genetica.length; i++) {
            if (genetica[i]) {
                aptidao += Main.itens.get(i).getValor();
            }
        }
        
        return aptidao - Main.penalidade*Math.max(0,getPeso() - Main.carga);
    }
    
    public double getPeso() {
        double peso = 0;
        for (int i = 0; i < genetica.length; i++) {
            if (genetica[i]) {
                peso += Main.itens.get(i).getPeso();
            }
        }
        return peso;
    }
    
    public boolean[] getGenetica() {
        return genetica;
    }

    public void setGenetica(boolean[] genetica) {
        this.genetica = genetica;
    }

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }
}
