
package telaa;


public class ExcecaoCPFInvalido extends Exception {
    
    private String cpf;
	
	public ExcecaoCPFInvalido(String mensagem,String cpf){
		super(mensagem);
		this.cpf = cpf;
	}
	
	public String getCPF(){
		return cpf;
	}
    
}
