import domain.ControlEnParada;
import domain.Recorrido;
import domain.direccion.CalculadorDeDistancia;

import java.util.List;

public class SinDemora implements ControlEnParada {
    @Override
    public Integer tiempoDeRecorrido(CalculadorDeDistancia calculadorDeDistancia, List<Recorrido> recorridos) {
        Integer tiempoTotal = 0;
        for (Recorrido recorrido : recorridos) {
            tiempoTotal += recorrido.tiempoDeRecorrido(calculadorDeDistancia);
        }
        return tiempoTotal;
    }
}
