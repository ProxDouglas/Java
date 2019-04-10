package implementacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private final double OCUPACAO;
    private final double TAMANHO_DO_LINK = 10000000;
    private final double TAMANHO_DOS_PACOTES = 1500;
    private final double PESO_CLASSE_0 = 1;
    private final double PESO_CLASSE_1 = 1.4;
    private final double PESO_CLASSE_2 = 1.6;
    private final double TEMPO_TOTAL_SIMULACAO = 10000;

    private double lSaida;
    private double lChegada;
    private double quantPacotes;
    private double tempoSaida = 0d;
    private double tempoChegada = 0d;

    private double somatorioUtilizacao = 0;
    private double somatorioUtilizacaoFila1 = 0;
    private double somatorioUtilizacaoFila2 = 0;
    private double somatorioUtilizacaoFila3 = 0;
    private double somatorioEn = 0;
    private double somatorioEnFila1 = 0;
    private double somatorioEnFila2 = 0;
    private double somatorioEnFila3 = 0;
    private double somatorioEw = 0;
    private double somatorioEwFila1 = 0;
    private double somatorioEwFila2 = 0;
    private double somatorioEwFila3 = 0;
    
    private int contadorTotalPacotes = 0;
    private int contadorClasse0 = 0;
    private int contadorClasse1 = 0;
    private int contadorClasse2 = 0;
    private int contadorSaidaPacote = 0;
    private int contadorSaidaPacoteFila1 = 0;
    private int contadorSaidaPacoteFila2 = 0;
    private int contadorSaidaPacoteFila3 = 0;
    
    private double horaDeMedirOErro = 100;

    private ArrayList<Pacote> fila1 = new ArrayList<>();
    private ArrayList<Pacote> fila2 = new ArrayList<>();
    private ArrayList<Pacote> fila3 = new ArrayList<>();

    private BufferedWriter br;
    
    private double tempoSimulacao = 0;
    private double tempoAnterior = 0;

    public Main(double ocupacao) throws IOException {
        OCUPACAO = ocupacao;
        quantPacotes = (TAMANHO_DO_LINK * OCUPACAO / (TAMANHO_DOS_PACOTES * 8) ) * TEMPO_TOTAL_SIMULACAO;
        lChegada = 1 / (TEMPO_TOTAL_SIMULACAO / quantPacotes);
        lSaida = 1 / ((TEMPO_TOTAL_SIMULACAO / quantPacotes) * OCUPACAO);
        br = new BufferedWriter(new FileWriter("arquivoResultados.txt",true));
    }

    public double maior(double primeiro, double segundo, double terceiro) {
        if (primeiro >= segundo && primeiro >= terceiro) {
            return primeiro;
        } else if (segundo >= primeiro && segundo >= terceiro) {
            return segundo;
        } else {
            return terceiro;
        }
    }

    public static double aleatorio(Random gerador) {
        double d = gerador.nextDouble();
        return 1.0 - d;
    }

    public Pacote gerarPacote(double tempo) {
        Pacote p = new Pacote();
        double valorRandom = Math.random();

        if (valorRandom < 0.25) {
            p.setClasse(Classe.CLASSE_0);
        } else if (valorRandom < 0.60) {
            p.setClasse(Classe.CLASSE_1);
        } else {
            p.setClasse(Classe.CLASSE_2);
        }

        p.setTempoChegada(tempo);
        return p;
    }
    
    public void margemErro(double tempoSimulacao){
        double result = 0;
        boolean flag = true;
        
        if(fila1.isEmpty() && !fila2.isEmpty() && !fila3.isEmpty()){
            double t2 = tempoSimulacao - fila2.get(0).getTempoChegada() / PESO_CLASSE_1;
            double t3 = tempoSimulacao - fila3.get(0).getTempoChegada() / PESO_CLASSE_2;
            result = Math.abs((t2/t3) - (PESO_CLASSE_1 / PESO_CLASSE_2));
            result /= 2;
        }else
        if(!fila1.isEmpty() && !fila2.isEmpty() && fila3.isEmpty()){
            double t2 = tempoSimulacao - fila1.get(0).getTempoChegada() / PESO_CLASSE_0;
            double t3 = tempoSimulacao - fila2.get(0).getTempoChegada() / PESO_CLASSE_1;
            result = Math.abs((t2/t3) - (PESO_CLASSE_0 / PESO_CLASSE_1));
            result /= 2;
        }else
        if(!fila1.isEmpty() && fila2.isEmpty() && !fila3.isEmpty()){
            double t2 = tempoSimulacao - fila1.get(0).getTempoChegada() / PESO_CLASSE_0;
            double t3 = tempoSimulacao - fila3.get(0).getTempoChegada() / PESO_CLASSE_2;
            result = Math.abs((t2/t3) - (PESO_CLASSE_0 / PESO_CLASSE_2));
            result /= 2;
        }else
        if(!fila1.isEmpty() && !fila2.isEmpty() && !fila3.isEmpty()){
            double sum = 0;
            double t2 = tempoSimulacao - fila1.get(0).getTempoChegada() / PESO_CLASSE_0;
            double t3 = tempoSimulacao - fila2.get(0).getTempoChegada() / PESO_CLASSE_1;
            sum += Math.abs((t2/t3) - (PESO_CLASSE_0 / PESO_CLASSE_1));
            
            t2 = tempoSimulacao - fila2.get(0).getTempoChegada() / PESO_CLASSE_1;
            t3 = tempoSimulacao - fila3.get(0).getTempoChegada() / PESO_CLASSE_2;
            sum += Math.abs((t2/t3) - (PESO_CLASSE_1 / PESO_CLASSE_2));
            
            result = sum / 2;
        }else{
            flag = false;
        }
        
        System.out.println(result + "\n");
        
        if(flag){
            try {
                br.append(result + "\n");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                br.append("NÃO FOI POSSÍVEL CALCULAR" + "\n");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            br.flush();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void executar() {
        Info en, ewAlfa, ewBeta;
        
        long semente = System.currentTimeMillis();
        Random gerador = new Random(semente);
        System.out.println(" Semente = " + semente);

        do {

            if (tempoSaida > 0d) {
                tempoSimulacao = Math.min(tempoChegada, tempoSaida);
            } else {
                tempoSimulacao = tempoChegada;
            }

            double diferenca = tempoSimulacao - tempoAnterior;
            double tamanhoDasFilas = fila1.size() + fila2.size() + fila3.size();

            if (tamanhoDasFilas > 0) // CALCULANDO TAXA DE UTILIZACAO DO SISTEMA COMO UM TODO.              
                somatorioUtilizacao = somatorioUtilizacao + diferenca;
            
            if(!fila1.isEmpty()) // CALCULANDO TAXA DE UTILIZACAO DA FILA 1
                somatorioUtilizacaoFila1 += diferenca;
            
            if(!fila2.isEmpty()) // CALCULANDO TAXA DE UTILIZACAO DA FILA 2
                somatorioUtilizacaoFila2 += diferenca;
            
            if(!fila3.isEmpty()) // CALCULANDO TAXA DE UTILIZACAO DA FILA 3
                somatorioUtilizacaoFila3 += diferenca;

            somatorioEn += diferenca * tamanhoDasFilas; // CALCULANDO E[N] DO SISTEMA.
            
            somatorioEnFila1 += diferenca * fila1.size();
            somatorioEnFila2 += diferenca * fila2.size();
            somatorioEnFila3 += diferenca * fila3.size();

            if(tempoSimulacao >= horaDeMedirOErro){
                margemErro(horaDeMedirOErro);
                horaDeMedirOErro += 100;
            }
            
            if (tempoSimulacao == tempoChegada) {

                Pacote p = gerarPacote(tempoSimulacao);
                if (p.getClasse() == Classe.CLASSE_0) {
                    fila1.add(p);
                    contadorClasse0++;
                }
                if (p.getClasse() == Classe.CLASSE_1) {
                    fila2.add(p);
                    contadorClasse1++;
                }
                if (p.getClasse() == Classe.CLASSE_2) {
                    fila3.add(p);
                    contadorClasse2++;
                }

                if (tempoSaida == 0) {
                    tempoSaida = tempoSimulacao + (-1.0 / lSaida) * Math.log(aleatorio(gerador));
                }

                tempoChegada = tempoSimulacao + (-1.0 / lChegada) * Math.log(aleatorio(gerador));

                contadorTotalPacotes++;
            } else {
                double atraso;
                double atraso0 = 0;
                double atraso1 = 0;
                double atraso2 = 0;

                if (!fila1.isEmpty()) {
                    Pacote pClasse0 = fila1.get(0);
                    atraso0 = (tempoSimulacao - pClasse0.getTempoChegada()) / PESO_CLASSE_0;
                }
                if (!fila2.isEmpty()) {
                    Pacote pClasse1 = fila2.get(0);
                    atraso1 = (tempoSimulacao - pClasse1.getTempoChegada()) / PESO_CLASSE_1;
                }
                if (!fila3.isEmpty()) {
                    Pacote pClasse2 = fila3.get(0);
                    atraso2 = (tempoSimulacao - pClasse2.getTempoChegada()) / PESO_CLASSE_2;
                }

                atraso = maior(atraso0, atraso1, atraso2);
                Pacote p = null;                

                if (atraso == atraso0) {
                    p = fila1.remove(0);
                    somatorioEwFila1 += tempoSimulacao - p.getTempoChegada();
                    contadorSaidaPacoteFila1++;
                    
                } else if (atraso == atraso1) {
                    p = fila2.remove(0);
                    somatorioEwFila2 += tempoSimulacao - p.getTempoChegada();
                    contadorSaidaPacoteFila2++;
                    
                } else if (atraso == atraso2) {
                    p = fila3.remove(0);
                    somatorioEwFila3 += tempoSimulacao - p.getTempoChegada();
                    contadorSaidaPacoteFila3++;

                }
                
                somatorioEw += tempoSimulacao - p.getTempoChegada();
                contadorSaidaPacote++;
                
                if (fila1.isEmpty() && fila2.isEmpty() && fila3.isEmpty()) {
                    tempoSaida = 0;
                } else {
                    tempoSaida = tempoSimulacao + (-1.0 / lSaida) * Math.log(aleatorio(gerador));
                }

            }

            tempoAnterior = tempoSimulacao;

        } while (tempoSimulacao <= TEMPO_TOTAL_SIMULACAO);

        printarStatusSistema();
        printarStatusFilas();

    }
    
    public void printarStatusSistema(){
        DecimalFormat df = new DecimalFormat("0.0000000000");
        System.out.println("=====================================================================");
        System.out.println("TAXA DE OCUPAÇÃO DO SISTEMA = " + somatorioUtilizacao / tempoSimulacao + "%");
        System.out.println("=====================================================================");
        System.out.println("E[N] DO SISTEMA = " + somatorioEn / tempoSimulacao);
        System.out.println("=====================================================================");
        System.out.println("LAMBDA = " + contadorTotalPacotes / tempoSimulacao);
        System.out.println("=====================================================================");
        System.out.println("E[W] DO SISTEMA = " + somatorioEw / contadorSaidaPacote);
        System.out.println("=====================================================================");
        System.out.println("LITTLE DO SISTEMA = " + df.format(Math.abs((somatorioEn / tempoSimulacao) - ((contadorTotalPacotes / tempoSimulacao) * (somatorioEw / contadorSaidaPacote)))));
        
        // FALTA E[W] E DIFERENÇA - LITTLE;
        System.out.println("=====================================================================");
        System.out.println("% DE PACOTES CLASSE 0 = " + (double) contadorClasse0 / contadorTotalPacotes * 100);
        System.out.println("% DE PACOTES CLASSE 1 = " + (double) contadorClasse1 / contadorTotalPacotes * 100);
        System.out.println("% DE PACOTES CLASSE 2 = " + (double) contadorClasse2 / contadorTotalPacotes * 100);
        System.out.println("=====================================================================");
    }
    
    public void printarStatusFilas(){
        DecimalFormat df = new DecimalFormat("0.0000000000");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("=====================================================================");
        System.out.println("\t\t\tFILA 1 - CLASSE 0");        
        System.out.println("=====================================================================");
        System.out.println("E[N] DA FILA = " + somatorioEnFila1 / tempoSimulacao);
        System.out.println("=====================================================================");
        System.out.println("TAXA DE OCUPAÇÃO DA FILA = " + somatorioUtilizacaoFila1 / tempoSimulacao + "%");
        System.out.println("=====================================================================");
        System.out.println("LAMBDA = " + contadorClasse0 / tempoSimulacao);
        System.out.println("=====================================================================");
        System.out.println("E[W] DA FILA = " + somatorioEwFila1 / contadorSaidaPacoteFila1);
        System.out.println("=====================================================================");
        System.out.println("LITTLE DA FILA = " + df.format(Math.abs((somatorioEnFila1 / tempoSimulacao) - ((contadorClasse0 / tempoSimulacao) * (somatorioEwFila1 / contadorSaidaPacoteFila1)))));
        System.out.println("=====================================================================");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("=====================================================================");
        System.out.println("\t\t\tFILA 2 - CLASSE 1");        
        System.out.println("=====================================================================");
        System.out.println("TAXA DE OCUPAÇÃO DA FILA = " + somatorioUtilizacaoFila2 / tempoSimulacao + "%");
        System.out.println("=====================================================================");
        System.out.println("E[N] DA FILA = " + somatorioEnFila2 / tempoSimulacao);
        System.out.println("=====================================================================");
        System.out.println("LAMBDA = " + contadorClasse1 / tempoSimulacao);
        System.out.println("=====================================================================");
        System.out.println("E[W] DA FILA = " + somatorioEwFila2 / contadorSaidaPacoteFila2);
        System.out.println("=====================================================================");
        System.out.println("LITTLE DA FILA = " + df.format(Math.abs((somatorioEnFila2 / tempoSimulacao) - ((contadorClasse1 / tempoSimulacao) * (somatorioEwFila2 / contadorSaidaPacoteFila2)))));
        System.out.println("=====================================================================");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("=====================================================================");
        System.out.println("\t\t\tFILA 3 - CLASSE 2");        
        System.out.println("=====================================================================");
        System.out.println("TAXA DE OCUPAÇÃO DA FILA = " + somatorioUtilizacaoFila3 / tempoSimulacao + "%");
        System.out.println("=====================================================================");
        System.out.println("E[N] DA FILA = " + somatorioEnFila3 / tempoSimulacao);
        System.out.println("=====================================================================");
        System.out.println("LAMBDA = " + contadorClasse2 / tempoSimulacao);
        System.out.println("=====================================================================");
        System.out.println("E[W] DA FILA = " + somatorioEwFila3 / contadorSaidaPacoteFila3);
        System.out.println("=====================================================================");
        System.out.println("LITTLE DA FILA = " + df.format(Math.abs((somatorioEnFila3 / tempoSimulacao) - ((contadorClasse2 / tempoSimulacao) * (somatorioEwFila3 / contadorSaidaPacoteFila3)))));
        System.out.println("=====================================================================");
    }  

    public static void main(String[] args) {
        try {
            Main m = new Main(0.98);
            m.executar();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class Info {

        private double tempoAnterior = 0d;
        private long numEventos = 0;
        private double somaDasAreas = 0d;

        public double getTempoAnterior() {
            return tempoAnterior;
        }

        public void setTempoAnterior(double tempoAnterior) {
            this.tempoAnterior = tempoAnterior;
        }

        public long getNumEventos() {
            return numEventos;
        }

        public void setNumEventos(long numEventos) {
            this.numEventos = numEventos;
        }

        public double getSomaDasAreas() {
            return somaDasAreas;
        }

        public void setSomaDasAreas(double somaDasAreas) {
            this.somaDasAreas = somaDasAreas;
        }
    }
}
