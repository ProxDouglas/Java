package telaa;

public class CadastrarPessoa {

    private String nome;
    private String rua;
    private String bairro;
    private String num;
    private String pai;
    private String mae;
    private String rg;
    private String cpf;
    private String telefone;
    private String dataDeNascimento;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws ExcecaoCampoVazio {
       if(rua.equals("")){
           throw new ExcecaoCampoVazio("Campo Rua vazio.");
       }
        this.rua = rua;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ExcecaoCampoVazio {
        if(nome.equals("")){
           throw new ExcecaoCampoVazio("Campo Nome vazio.");
       }
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws ExcecaoCampoVazio {
        if(bairro.equals("")){
           throw new ExcecaoCampoVazio("Campo Bairro vazio.");
       }
        this.bairro = bairro;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) throws ExcecaoCampoVazio {
        if(num.equals("")){
           throw new ExcecaoCampoVazio("Campo Numero vazio.");
       }
        this.num = num;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) throws ExcecaoCampoVazio {
       if(pai.equals("")){
           throw new ExcecaoCampoVazio("Campo Pai vazio.");
       }
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) throws ExcecaoCampoVazio {
        if(mae.equals("")){
           throw new ExcecaoCampoVazio("Campo Mae vazio.");
       }
        this.mae = mae;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) throws ExcecaoCampoVazio {
        if(rg.equals("")){
           throw new ExcecaoCampoVazio("Campo RG vazio.");
       }
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ExcecaoCampoVazio {
       if(cpf.equals("")){
           throw new ExcecaoCampoVazio("Campo CPF vazio.");
       }
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws ExcecaoCampoVazio {
       if(telefone.equals("")){
           throw new ExcecaoCampoVazio("Campo Telefone vazio.");
       }
        this.telefone = telefone;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) throws ExcecaoCampoVazio {
       if(dataDeNascimento.equals("")){
           throw new ExcecaoCampoVazio("Campo Data de Nascimento vazio.");
       }
        this.dataDeNascimento = dataDeNascimento;
    }
}
