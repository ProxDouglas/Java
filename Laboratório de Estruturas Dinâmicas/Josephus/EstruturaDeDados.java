public class EstruturaDeDados 
{
    private int count;
    private No inicio;
    private No fim;
    private No atual;
    public EstruturaDeDados getAtual;

    public EstruturaDeDados() 
    {
        inicio = null;
        fim = null;
        atual = null;
        count = 0;
    }

    public boolean estaVazia() 
    {   
        if(inicio == null){
            return true;
        }

        return false;
    }

    public No getAtual() 
    {
        return atual;
    }

    public No getInicio() 
    {
        return inicio;
    }

    public void mover() 
    {
        atual = atual.proximo;
    }

    public void inserir(int x) 
    {
        No no = new No(x);

        if (estaVazia() == true) {
            inicio = no;
            atual = inicio;
        }
        if (estaVazia() == false) {
            atual.proximo = no;
        }

        no.proximo = inicio;
        fim = no;
        mover();
        count++;
    }

    public void deletar(int x) 
    {
        No anterior = inicio;
        No posAtual = inicio.proximo;

        while (posAtual.dado != x) {
            anterior = posAtual;
            posAtual = posAtual.proximo;
        }

        if (count == 1) {
            inicio = null;
            count--;
        } else if (posAtual == inicio) {
            anterior.proximo = posAtual.proximo;
            inicio = posAtual.proximo;
            count--;
        } else {
            anterior.proximo = posAtual.proximo;
            count--;
        }
    }

    public void mostrarLista() 
    {
        No imprimir = inicio;

        for (int x = 0; x < count; x++) {
            imprimir.mostrarNo();
            imprimir = imprimir.proximo;
        }

        System.out.println("");
    }

}
