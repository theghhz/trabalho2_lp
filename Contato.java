import java.io.Serializable;

public class Contato implements Serializable{
    
    private String nome;
    private String telefone;
    private String endereco;
    private String relacao;

    public Contato(String nome, String telefone, String endereco, String relacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.relacao = relacao;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getRelacao() {
        return relacao;
    }

    @Override
    public String toString() {
        return 
            "-----------------------------" +
            "Nome: " + nome + 
            "\nTelefone: " + telefone + 
            "\nEndereço: " + endereco +
            "\nRelação: " + relacao + 
            "-----------------------------" + 
            "\n"
            ;
    }
    
}