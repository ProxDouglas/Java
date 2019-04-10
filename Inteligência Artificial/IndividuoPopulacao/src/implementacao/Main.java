package implementacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static ArrayList<Item> itens;
    public static double carga;
    public static int numItens;
    public static double txCrossOver;
    public static boolean elitismo;
    public static double txMutacao;
    public static int tamPopulacao;
    public static double penalidade;
    public static Random r = new Random();

    public static void leitor(String path) throws FileNotFoundException, IOException {
        itens = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(path));
        carga = Double.parseDouble(bf.readLine());
        numItens = Integer.parseInt(bf.readLine());
        for (int i = 0; i < numItens; i++) {
            String[] valorPeso = bf.readLine().split("\t");
            System.out.println(valorPeso[0] + "\t" + valorPeso[1]);
            Item item = new Item();
            item.setValor(Double.parseDouble(valorPeso[0]));
            item.setPeso(Double.parseDouble(valorPeso[1]));
            itens.add(item);
        }
    }

    public static Populacao novaGeracao(Populacao populacaoAtual) {
        Populacao novaPopulacao = new Populacao(tamPopulacao);

        if (elitismo) {
            novaPopulacao.setIndividuo(populacaoAtual.getIndividuo(0));
        }
        while (novaPopulacao.getNumIndividuos() < tamPopulacao) {
            //seleciona os 2 pais por torneio
            Individuo[] pais = selecaoTorneio(populacaoAtual);

            Individuo[] filhos = new Individuo[2];

            //verifica a taxa de crossover, se sim realiza o crossover, se não, mantém os pais selecionados para a próxima geração
            if (r.nextDouble() <= txCrossOver) {
                filhos = crossover(pais[1], pais[0]);
            } else {
                filhos[0] = pais[0];
                filhos[1] = pais[1];
            }

            //adiciona os filhos na nova geração
            novaPopulacao.setIndividuo(filhos[0]);
            novaPopulacao.setIndividuo(filhos[1]);
        }

        //ordena a nova população
        novaPopulacao.ordenarIndividuos();
        return novaPopulacao;
    }

    private static Individuo[] selecaoTorneio(Populacao populacao) {
        Random r = new Random();
        Populacao populacaoIntermediaria = new Populacao(3);

        //seleciona 3 indivíduos aleatóriamente na população
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(tamPopulacao)));
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(tamPopulacao)));
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(tamPopulacao)));

        //ordena a população
        populacaoIntermediaria.ordenarIndividuos();

        Individuo[] pais = new Individuo[2];

        //seleciona os 2 melhores deste população
        pais[0] = populacaoIntermediaria.getIndividuo(0);
        pais[1] = populacaoIntermediaria.getIndividuo(1);

        return pais;
    }

    private static Individuo[] crossover(Individuo individuo1, Individuo individuo2) {
        Random r = new Random();
        boolean geneticaFilho1[] = new boolean[itens.size()];
        boolean geneticaFilho2[] = new boolean[itens.size()];

        //sorteia o ponto de corte
        int pontoCorte1 = r.nextInt(itens.size());

        Individuo[] filhos = new Individuo[2];

        //pega os genes dos pais
        for (int i = 0; i < itens.size(); i++) {
            if (i <= pontoCorte1) {
                geneticaFilho1[i] = individuo1.getGenetica()[i];
            } else {
                geneticaFilho1[i] = individuo2.getGenetica()[i];
            }
        }

        for (int i = 0; i < itens.size(); i++) {
            if (i <= pontoCorte1) {
                geneticaFilho1[i] = individuo1.getGenetica()[i];
            } else {
                geneticaFilho1[i] = individuo2.getGenetica()[i];
            }
        }

        for (int i = 0; i < itens.size(); i++) {
            if (i <= pontoCorte1) {
                geneticaFilho2[i] = individuo2.getGenetica()[i];
            } else {
                geneticaFilho2[i] = individuo1.getGenetica()[i];
            }
        }
        
        if(r.nextDouble() < txMutacao){
            int pos = r.nextInt(itens.size());
            geneticaFilho1[pos] = !geneticaFilho1[pos];
            geneticaFilho2[pos] = !geneticaFilho2[pos];
        }

        //cria o novo indivíduo com os genes dos pais
        filhos[0] = new Individuo(itens.size());
        filhos[1] = new Individuo(itens.size());

        filhos[0].setGenetica(geneticaFilho1);
        filhos[1].setGenetica(geneticaFilho2);

        return filhos;
    }
    
    public static double calcularPenalidade(){
        double sum = 0;
        for (Item item  : itens) {
            sum += item.getValor();
        }       
        return sum;
    }

            
            

    public static void main(String[] args) {
        try {
            leitor("/srv/matheusflausino/Downloads/teste20000.txt");
            Main.txCrossOver = 0.5;
            Main.txMutacao = 0.5;
            Main.elitismo = true;
            Main.tamPopulacao = 25;
            Main.penalidade = calcularPenalidade();
            int numMaxGeracoes = 100000;

            Populacao populacao = new Populacao(Main.tamPopulacao);
            populacao.gerarNovaPopulacao();
            
            int geracao = 0;

            //loop até o critério de parada
            while (geracao < numMaxGeracoes) {
                geracao++;

                //cria nova populacao
                populacao = Main.novaGeracao(populacao);

                //System.out.println("Geração " + geracao + " | Melhor Aptidão: " + populacao.getIndividuo(0).getAptidao());

                //verifica se tem a solucao
            }

            if (geracao == numMaxGeracoes) {
                System.out.println("Número Maximo de Gerações | " + populacao.getIndividuo(0).getAptidao());
                System.out.println("PESO = " + populacao.getIndividuo(0).getPeso());
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
