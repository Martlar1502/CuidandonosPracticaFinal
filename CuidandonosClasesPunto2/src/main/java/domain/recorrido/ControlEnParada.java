package domain.recorrido;

import domain.direccion.CalculadorDeDistancia;

import java.util.List;

public interface ControlEnParada {
    public Integer tiempoDeRecorrido(CalculadorDeDistancia calculadorDeDistancia, List<Recorrido> recorridos);

}
