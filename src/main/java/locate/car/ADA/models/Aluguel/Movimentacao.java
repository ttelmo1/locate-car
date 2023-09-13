package locate.car.ADA.models.Aluguel;

import locate.car.ADA.models.GerarID;
import locate.car.ADA.models.Pessoas.Pessoa;
import locate.car.ADA.models.Veiculos.Veiculo;

import java.util.HashSet;
import java.util.Set;


public class Movimentacao implements GerarID {

    TabelaMovimentacoes tabelaMovimentacoes = TabelaMovimentacoes.getInstancia();
    private static final Set<String> idsUnicos = new HashSet<String>();
    private static final Set<String> tabelaTransacoes = new HashSet<String>();

    private String idMovimentacao;
    private String idTransacao;

    private TipoMovimentacao tipoMovimentacao;
    private String localMovimentacao;
    private String dataHoraMovimentacao;
    private double ValorMovimentacao;

    private Pessoa locatario;
    private Veiculo veiculo;

    public Movimentacao(TipoMovimentacao tipoMovimentacao, String localMovimentacao, String dataHoraMovimentacao, Pessoa locatario, Veiculo veiculo) {

        if(tipoMovimentacao == TipoMovimentacao.RETIRADA) {
            if(veiculo.isAlugado()) {
                throw new IllegalArgumentException("Veículo está alugado, indisponível");
            }

            this.locatario = locatario;

            idTransacao = gerarID();
            while(tabelaTransacoes.contains(idTransacao)) {
                idTransacao = Integer.toString(GERADOR.nextInt(10000));
            }
            tabelaTransacoes.add(idTransacao);


            veiculo.setAlugado(true);

        }

        if(tipoMovimentacao == TipoMovimentacao.DEVOLUCAO) {
            if(!veiculo.isAlugado()) {
                throw new IllegalArgumentException("Veículo informado não está alugado, movimentacao inicial encontrada");
            }
            // Em construcao
            //int indexUltimaMovimentacaoDoVeiculo = tabelaMovimentacoes.getMovimentacoes().;
            //Movimentacao ultimaMovimentacaoDoVeiculo = tabelaMovimentacoes.getMovimentacoes().get(indexUltimaMovimentacaoDoVeiculo);

            //this.idTransacao = ultimaMovimentacaoDoVeiculo.idTransacao;

            veiculo.setAlugado(false);
        }

        idMovimentacao = gerarID();
        while(idsUnicos.contains(idMovimentacao)) {
            idMovimentacao = Integer.toString(GERADOR.nextInt(10000));
        }
        idsUnicos.add(idMovimentacao);


        this.veiculo = veiculo;
        this.locatario = locatario;
        this.tipoMovimentacao = tipoMovimentacao;
        this.localMovimentacao = localMovimentacao;
        this.dataHoraMovimentacao = dataHoraMovimentacao;

        tabelaMovimentacoes.adicionarMovimentacao(this);
    }

    public String gerarID() {
        String id = Integer.toString(GERADOR.nextInt(10000));
        return id;
    }


    public String getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(String idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String getLocalMovimentacao() {
        return localMovimentacao;
    }

    public void setLocalMovimentacao(String localMovimentacao) {
        this.localMovimentacao = localMovimentacao;
    }

    public String getDataHoraMovimentacao() {
        return dataHoraMovimentacao;
    }

    public void setDataHoraMovimentacao(String dataHoraMovimentacao) {
        this.dataHoraMovimentacao = dataHoraMovimentacao;
    }

    public double getValorMovimentacao() {
        return ValorMovimentacao;
    }

    public void setValorMovimentacao(double valorMovimentacao) {
        ValorMovimentacao = valorMovimentacao;
    }

    public Pessoa getLocatario() {
        return locatario;
    }

    public void setLocatario(Pessoa locatario) {
        this.locatario = locatario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                " idMovimentacao='" + idMovimentacao + '\'' +
                ", idTransacao=" + idTransacao +
                ", tipoMovimentacao=" + tipoMovimentacao +
                ", localMovimentacao='" + localMovimentacao + '\'' +
                ", dataHoraMovimentacao='" + dataHoraMovimentacao + '\'' +
                ", ValorMovimentacao=" + ValorMovimentacao +
                ", idLocatario=" + locatario.getIdPessoa() +
                ", locatario=" + locatario.getNome() +
                ", idVeiculo=" + veiculo.getIdVeiculo() +
                ", modeloVeiculo=" + veiculo.getModelo() +
                '}';
    }
}
