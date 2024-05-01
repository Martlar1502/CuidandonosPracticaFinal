package domain.recorrido;

import domain.direccion.CalculadorDeDistancia;

import java.util.List;

public class RecorridoConParadas extends Recorrido{

    private List<Recorrido> recorridos;
    private ControlEnParada controlEnParada;

    @Override
    public Integer tiempoDeRecorrido(CalculadorDeDistancia calculadorDeDistancia) {
        return controlEnParada.tiempoDeRecorrido(calculadorDeDistancia,this.recorridos);
    }
}
