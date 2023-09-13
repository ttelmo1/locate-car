package locate.car.ADA.models.Aluguel;

import locate.car.ADA.models.Pessoas.BaseClientes;
import locate.car.ADA.models.Pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class TabelaMovimentacoes {

    private static TabelaMovimentacoes instancia = null;
    private List<Movimentacao> movimentacoes;

    private TabelaMovimentacoes() {
        movimentacoes = new ArrayList<>();
    }

    public static TabelaMovimentacoes getInstancia() {
        if (instancia == null) {
            instancia = new TabelaMovimentacoes();
        }
        return instancia;
    }

    public void adicionarMovimentacao(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
    }

    public void removerMovimentacao(Movimentacao movimentacao) {
        movimentacoes.remove(movimentacao);
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tabela de Movimentacoes:\n");

        for (Movimentacao movimentacao : movimentacoes) {
            sb.append(movimentacao.toString()).append("\n");
        }
        return sb.toString();
    }

}