package ExceptionHandling.Excessoes_E_POO;

public class Pessoas
{
    int id;
    String nome;
    String endereco;
    String cpf;

    public Pessoas(int id, String nome, String endereco, String cpf)
    {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString()
    {
        return "Pessoas {" +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", endereco: '" + endereco + '\'' +
                ", cpf: '" + cpf + '\'' +
                '}';
    }
}
