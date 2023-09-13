package locate.car.ADA.models.Veiculos;

import locate.car.ADA.models.BuscaPeloNome;

import java.util.ArrayList;
import java.util.List;

public class Frota  implements BuscaPeloNome<Veiculo> {
    private static Frota instancia = null;
    private List<Veiculo> veiculos;

    private Frota() {
        veiculos = new ArrayList<>();
    }

    public static Frota getInstancia() {
        if (instancia == null) {
            instancia = new Frota();
        }
        return instancia;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public List<Veiculo> bucaPeloNome(String nome) {
        List<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().toLowerCase().contains(nome.toLowerCase())) {
                veiculosEncontrados.add(veiculo);
            }
        }
        return veiculosEncontrados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Frota de Veículos:\n");

        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo.toString()).append("\n");
        }

        return sb.toString();
    }
}
