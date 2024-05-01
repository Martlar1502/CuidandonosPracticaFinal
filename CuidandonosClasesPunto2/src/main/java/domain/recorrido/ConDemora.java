package domain.recorrido;

import domain.direccion.CalculadorDeDistancia;

import java.util.List;

public class ConDemora implements ControlEnParada{
    private List<Integer> minutosDetencionPorParada;
    @Override
    public Integer tiempoDeRecorrido(CalculadorDeDistancia calculadorDeDistancia, List<Recorrido> recorridos) {
        Integer tiempoTotal = 0;
        for (Recorrido recorrido : recorridos) {
            tiempoTotal += recorrido.tiempoDeRecorrido(calculadorDeDistancia);
        }
        return tiempoTotal + minutosDetencionPorParada.stream().mapToInt(i -> i).sum();
    }

}
