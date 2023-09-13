package locate.car.ADA.models.Pessoas;

import locate.car.ADA.models.GerarID;

import java.util.HashSet;
import java.util.Set;

public abstract class Pessoa implements GerarID {

    private static final Set<String> identificadoresUnicos = new HashSet<String>();
    private static final Set<String> idsUnicos = new HashSet<String>();

    protected String idPessoa;
    protected String endereco;
    protected String contato;
    protected String identificador;

    public Pessoa(String endereco, String contato, String identificador) {

        if (identificadoresUnicos.contains(identificador)) {
            throw new IllegalArgumentException("Identificador único já cadastrado");
        }

        idPessoa = gerarID();
        while(idsUnicos.contains(idPessoa)) {
            idPessoa = Integer.toString(GERADOR.nextInt(10000));
        }
        idsUnicos.add(idPessoa);

        this.endereco = endereco;
        this.contato = contato;
        this.identificador = identificador;

        BaseClientes baseClientes = BaseClientes.getInstancia();
        baseClientes.adicionarCliente(this);

        identificadoresUnicos.add(identificador);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public abstract String getNome();

    public String getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }


    public String gerarID() {
       String id = Integer.toString(GERADOR.nextInt(10000));
       return id;
    }
}
