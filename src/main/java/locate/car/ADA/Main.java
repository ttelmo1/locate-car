package locate.car.ADA;

import locate.car.ADA.models.Aluguel.Movimentacao;
import locate.car.ADA.models.Aluguel.TabelaMovimentacoes;
import locate.car.ADA.models.Aluguel.TipoMovimentacao;
import locate.car.ADA.models.Pessoas.BaseClientes;
import locate.car.ADA.models.Pessoas.Pessoa;
import locate.car.ADA.models.Pessoas.PessoaFisica;
import locate.car.ADA.models.Pessoas.PessoaJuridica;
import locate.car.ADA.models.Veiculos.Carro;
import locate.car.ADA.models.Veiculos.*;

import java.awt.event.ItemListener;

public class Main {
    public static void main(String[] args) {

       Frota frota = Frota.getInstancia();
       BaseClientes baseClientes = BaseClientes.getInstancia();
       TabelaMovimentacoes tabelaMovimentacoes = TabelaMovimentacoes.getInstancia();

       System.out.println("Cadastrando Veículo");
       Carro carro = new Carro("ABCE", "Volkswagen", "Preto", "1972", "Bege", TipoCarro.MEDIO);
       Carro carro2 = new Carro("QRST", "Honda", "Civic", "2021", "Preto", TipoCarro.SUV);
       System.out.println(frota.toString());

       System.out.println("Alterando Veículo");
       carro2.setTipoCarro(TipoCarro.MEDIO);
       System.out.println(frota.toString());

       System.out.println("Buscando veículo por parte do nome (Modelo)");
       System.out.println(frota.bucaPeloNome("CIV")); // retorna uma lista
       System.out.println();

       System.out.println("Cadastrando Clientes");
       PessoaFisica pessoa1 = new PessoaFisica("Av. Alberto Magno 457", "85996445175", "06916326315", "Jonathan Silva", "15/10/1999");
       PessoaJuridica pessoa2 = new PessoaJuridica("Rua do Galeão 904", "85993135822", "07526557000100", "Ambev S/A", "Ambev");
       PessoaFisica pessoa5 = new PessoaFisica("Rua das Flores 123", "85996445176", "06916326316", "Maria Santos", "20/05/1985");
       System.out.println(baseClientes.toString());

       System.out.println("Buscando Cliente por parte do nome ou nomeFantasia");
       System.out.println(baseClientes.bucaPeloNome("v")); // retorna uma lista
       System.out.println();

       System.out.println("Alterando um cliente");
       pessoa1.setNome("Antonio Silva");
       pessoa2.setNomeFantasia("Ambev Distribuidora");
       System.out.println(baseClientes.toString());

       // Aluguel


       System.out.println("Cadastrando Placa Repetida");
       try {
          PessoaFisica pessoaRepetida = new PessoaFisica("Av. Alberto Magno 457", "85996445175", "06916326315", "Jonathan Silva", "15/10/1999");
          PessoaJuridica pessoaRepetida2 = new PessoaJuridica("Rua do Galeão 904", "85993135822", "07526557000100", "Ambev S/A", "Ambev");
       } catch (IllegalArgumentException e) {
         System.out.println("Erro ao criar cliente: " + e.getMessage());
      }
       System.out.println();

       System.out.println("Cadastrando Pessoa Repetida");
       try {
          Carro carro15 = new Carro("ABCE", "Volkswagen", "Preto", "1972", "Bege", TipoCarro.MEDIO);
       } catch (IllegalArgumentException e) {
          System.out.println("Erro ao criar carro: " + e.getMessage());
       }
       System.out.println();

       System.out.println("Cadastrando Movimentacoes (retirada - aluguel)");
       Movimentacao movimentacao1 = new Movimentacao(TipoMovimentacao.RETIRADA, "LOJA1", "15/10/2007:14:15", pessoa1, carro2);
       System.out.println(tabelaMovimentacoes.toString());
       System.out.println();


        System.out.println("Tentando retirar um veiculo já alugado");
        try {
            Movimentacao movimentacaoTeste = new Movimentacao(TipoMovimentacao.RETIRADA, "LOJA1", "15/10/2007:14:15", pessoa1, carro2);
        } catch(IllegalArgumentException e) {
            System.out.println("Erro ao criar movimetacao: " + e.getMessage());
        }

        System.out.println("Cadastrando Movimentacoes (devolucao)");
        Movimentacao movimentacao2 = new Movimentacao(TipoMovimentacao.DEVOLUCAO, "LOJA1", "15/10/2007:14:15", pessoa1, carro2);
        System.out.println(tabelaMovimentacoes.toString());
        System.out.println();






       //dataLoader();


    }

     static void dataLoader() {

        Frota frota = Frota.getInstancia();

        try {
           Carro carro1 = new Carro("ABCD", "Volkswagen", "Fusca", "1972", "Bege", TipoCarro.MEDIO);
           //Veiculo carro11 = new Carro("ABCD", "Volkswagen", "Fusca", "1972", "Bege", TipoCarro.PEQUENO);
           Carro carro2 = new Carro("EFGH", "Toyota", "Corolla", "2020", "Prata", TipoCarro.SUV);
           Carro carro3 = new Carro("IJKL", "Ford", "Mustang", "2023", "Vermelho", TipoCarro.MEDIO);
           Carro carro4 = new Carro("MNOP", "Chevrolet", "Camaro", "2023", "Amarelo", TipoCarro.PEQUENO);
           Carro carro5 = new Carro("QRST", "Honda", "Civic", "2021", "Preto", TipoCarro.SUV);
           Carro carro6 = new Carro("UVWX", "Nissan", "Sentra", "2022", "Azul", TipoCarro.MEDIO);
           Carro carro7 = new Carro("YZ01", "Hyundai", "Elantra", "2021", "Branco", TipoCarro.PEQUENO);
           Carro carro8 = new Carro("2345", "Kia", "Optima", "2022", "Prata", TipoCarro.SUV);
           Carro carro9 = new Carro("6789", "Mazda", "Mazda3", "2020", "Preto", TipoCarro.MEDIO);
           Carro carro10 =new Carro("AB12", "Subaru", "Impreza", "2021", "Azul", TipoCarro.PEQUENO);


        } catch (IllegalArgumentException e) {
           System.out.println("Erro ao criar carro: " + e.getMessage());
        }



        // System.out.println(frota.toString());

        BaseClientes baseClientes = BaseClientes.getInstancia();

        Pessoa pessoa3 = new PessoaFisica("Av. Alberto Magno 457", "85996445175", "06916326315", "Jonathan Silva", "15/10/1999");
        Pessoa pessoa4 = new PessoaJuridica("Rua do Galeão 904", "85993135822", "07526557000100", "Ambev S/A", "Ambev");
        Pessoa pessoa5 = new PessoaFisica("Rua das Flores 123", "85996445176", "06916326316", "Maria Santos", "20/05/1985");
        Pessoa pessoa6 = new PessoaJuridica("Av. Paulista 567", "85993135823", "07526557000101", "ABC Ltda.", "ABC");
        Pessoa pessoa7 = new PessoaFisica("Rua da Praia 789", "85996445177", "06916326317", "Pedro Oliveira", "10/12/1978");
        Pessoa pessoa8 = new PessoaJuridica("Rua dos Coqueiros 321", "85993135824", "07526557000102", "XYZ Comércio", "XYZ");
        Pessoa pessoa9 = new PessoaFisica("Av. das Palmeiras 654", "85996445178", "06916326318", "Luana Pereira", "25/03/1990");
        Pessoa pessoa10 = new PessoaJuridica("Rua das Árvores 987", "85993135825", "07526557000103", "DEF Indústria", "DEF");
        Pessoa pessoa11 = new PessoaFisica("Rua das Montanhas 987", "85996445179", "06916326319", "Rafaela Oliveira", "05/07/1980");
        Pessoa pessoa12 = new PessoaJuridica("Av. dos Lagos 321", "85993135826", "07526557000104", "GHI Tecnologia", "GHI");


       // System.out.println(baseClientes.toString());
    }
}