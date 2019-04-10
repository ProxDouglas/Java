package pedro.classes;

public class ClasseMan {
    
    public static void main(String[] args) throws InterruptedException {
        Processador processador = new Processador();
        
        Processo processo1 = new Processo("Matheus",2000);
        Processo processo2 = new Processo("Maik",1500);
        Processo processo3 = new Processo("Fabi",1600);
        Processo processo4 = new Processo("Lucas",1550);       
        
        processador.adicionarProcesso(processo1);
        processador.adicionarProcesso(processo2);
        processador.adicionarProcesso(processo3);
        processador.adicionarProcesso(processo4);
        
        processador.setQuantum(450);
        
        processador.executarProcessamento("RoR");
    
    }
    
}
