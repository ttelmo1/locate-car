package locate.car.ADA.models;

import java.util.List;

public interface BuscaPeloNome<T> {
    List<T> bucaPeloNome(String nome);
}
