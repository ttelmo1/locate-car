package locate.car.ADA.models.Pessoas;

public class PessoaJuridica extends Pessoa{

    String razaoSocial;
    String nomeFantasia;

    public PessoaJuridica(String endereco, String contato, String identificador, String razaoSocial, String nomeFantasia) {
        super(endereco, contato, identificador);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override // Necessário para implementar a busca por nome na BaseClientes
    public String getNome() {
        return nomeFantasia;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", endereco='" + endereco + '\'' +
                ", contato='" + contato + '\'' +
                ", cnpj='" + identificador + '\'' +
                '}';
    }
}
