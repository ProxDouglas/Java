public class Josephus 
{

    private int pessoas;
    private int count; 
    private No cabeca;
    private No calda;
    EstruturaDeDados estrutura;

    public Josephus() 
    {
        estrutura = new EstruturaDeDados();
        pessoas = 0;
        count = 0;
    }

    public int getPessoas() 
    {
        return pessoas;
    }

    public void setPessoas(int x) 
    {
        pessoas = x;

    }

    public int getCount() 
    {
        return count;
    }

    public void setCount(int x) 
    {
        count = x;
    }

    public void adicionarPessoas() 
    {
        for (int i = 1; i < pessoas; i++) {
            estrutura.inserir(i);
        }
    }

    public void mostrar() 
    {
        System.out.print("Vivo:  ");
        estrutura.mostrarLista();
    }

    public void matar() 
    {
        for (int i = 0; i < count; i++) {
            calda = cabeca;
            cabeca = cabeca.proximo;
        }

        System.out.println("Morto: " + cabeca.dado);
    }

    public void iniciar() 
    {
        calda = null;
        cabeca = estrutura.getInicio();

        while (pessoas != 2) {
            matar();
            estrutura.deletar(cabeca.dado);
            calda = calda.proximo;
            cabeca = cabeca.proximo;
            pessoas--;
            mostrar();
        }
    }

}