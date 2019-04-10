
package telaa;

import java.util.ArrayList;


public class Sistema {
    
    private ArrayList<CadastrarPessoa> pessoas = new ArrayList<>();	
	
	public void adicionarNovaPessoa(CadastrarPessoa pessoa){
		pessoas.add(pessoa);
	}
	
	public CadastrarPessoa getPessoa(String nome)throws ExcecaoPessoaNaoEncontrada{
          int i;
          for(i = 0;i<pessoas.size();i++){
              if(nome.equals(pessoas.get(i).getNome())){
                  return pessoas.get(i);
              }
          }
          throw new ExcecaoPessoaNaoEncontrada("Pessoa Não Encontrada",nome);          
	}

    
}
