package locate.car.ADA.models.Pessoas;
import locate.car.ADA.models.BuscaPeloNome;
import locate.car.ADA.models.GerarID;
import locate.car.ADA.models.Veiculos.Frota;
import locate.car.ADA.models.Veiculos.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class BaseClientes implements BuscaPeloNome<Pessoa>{

    String idCliente;

    private static BaseClientes instancia = null;
    private List<Pessoa> clientes;

    private BaseClientes() {
        clientes = new ArrayList<>();
    }

    public static BaseClientes getInstancia() {
        if (instancia == null) {
            instancia = new BaseClientes();
        }
        return instancia;
    }

    public void adicionarCliente(Pessoa pessoa) {
        clientes.add(pessoa);
    }

    public void removerCliente(Pessoa pessoa) {
        clientes.remove(pessoa);
    }

    public List<Pessoa> getClientes() {
        return clientes;
    }

    @Override
    public List<Pessoa> bucaPeloNome(String nome) {
        List<Pessoa> pessoasEncontradas = new ArrayList<>();

        for (Pessoa pessoa : clientes) {
            if (pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) {
                pessoasEncontradas.add(pessoa);
            }
        }
        return pessoasEncontradas;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Base de Clientes:\n");

        for (Pessoa cliente : clientes) {
            sb.append(cliente.toString()).append("\n");
        }

        return sb.toString();
    }

}