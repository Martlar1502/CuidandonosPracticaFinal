package domain;

import domain.direccion.CalculadorDeDistancia;

import java.util.List;

import static java.lang.Integer.sum;

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
