public class Main 
{

    public static void main(String[] args) 
    {
        Josephus josephus = new Josephus();

        josephus.setPessoas(8);
        josephus.adicionarPessoas();
        josephus.setCount(3);
        josephus.iniciar();
    }

}