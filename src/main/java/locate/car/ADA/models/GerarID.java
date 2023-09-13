package locate.car.ADA.models;

import java.util.Random;

public interface GerarID {
        public final static Random GERADOR = new Random();
        public String gerarID();
}
