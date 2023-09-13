package locate.car.ADA.models.Pessoas;

public class PessoaFisica extends Pessoa{

    String nome;
    String dataNascimento;

    public PessoaFisica(String endereco, String contato, String identificador, String nome, String dataNascimento) {
        super(endereco, contato, identificador);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "idPessoa='" + idPessoa + '\'' +
                ", cpf='" + identificador + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", contato='" + contato + '\'' +

                '}';
    }
}
