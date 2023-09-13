package locate.car.ADA.models.Veiculos;

public class Carro extends Veiculo {

    TipoCarro tipoCarro;

    public Carro(String placa, String marca, String modelo, String ano, String cor, TipoCarro tipoCarro) {
        super(placa, marca, modelo, ano, cor, TipoVeiculo.CARRO);
        this.tipoCarro = tipoCarro;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(TipoCarro tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "tipoCarro=" + tipoCarro +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                ", cor='" + cor + '\'' +
                ", tipoVeiculo=" + tipoVeiculo +
                '}';
    }
}
