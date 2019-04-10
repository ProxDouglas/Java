
package telaa;

public class ExcecaoPessoaNaoEncontrada extends Exception {
    
    private String nome;
    
    public ExcecaoPessoaNaoEncontrada(String mensagem,String nome){
        super(mensagem);
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
}
