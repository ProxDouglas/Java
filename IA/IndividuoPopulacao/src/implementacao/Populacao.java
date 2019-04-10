package implementacao;


public class Populacao {
    
    private Individuo individuos[];
    
    
    public Populacao(int tamanhoPopulacao){
        individuos = new Individuo[tamanhoPopulacao];
        for (int i = 0; i < tamanhoPopulacao; i++) {
            individuos[i] = null;
        }
    }
    
    public void gerarNovaPopulacao(){
        individuos[0] = new Individuo(Main.itens.size());
        individuos[0].allZeros();
        for (int i = 1; i < individuos.length; i++) {
            individuos[i] = new Individuo(Main.itens.size());
        }
    }
    
    public void ordenarIndividuos(){
        boolean houveTroca = true;
        while(houveTroca){
            houveTroca = false;
            for (int i = 0; i < individuos.length - 1; i++) {
                if(individuos[i].getAptidao() < individuos[i+1].getAptidao()){
                    Individuo aux = individuos[i];
                    individuos[i] = individuos[i+1];
                    individuos[i+1] = aux;
                    houveTroca = true;
                }
            }
        }
    }
    
    public Individuo getIndividuo(int pos){
        return individuos[pos]; 
    }
    
    public void setIndividuo(Individuo individuo) {
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] == null) {
                individuos[i] = individuo;
                return;
            }
        }
    }
    
    public int getNumIndividuos(){
        int cont = 0;
        for (int i = 0; i < individuos.length; i++) {
            if(individuos[i] != null){
                cont++;
            }
        }
        return cont;
    }
    
    
}
