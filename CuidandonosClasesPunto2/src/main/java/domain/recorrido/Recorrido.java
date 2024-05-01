package domain.recorrido;

import domain.direccion.CalculadorDeDistancia;
import domain.direccion.ControladorDeTiempo;
import domain.direccion.Direccion;
import domain.estado.EstadoDelRecorrido;
import domain.persona.Persona;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Recorrido {
    private Direccion direccionActual;
    private Direccion direccionDestino;
    private List<Persona> cuidadores;
    private LocalDateTime horarioInicio;
    private Integer duracionEstimada;
    private Boolean finalizado;
    private Persona transeunte;
    private EstadoDelRecorrido estado;
    public Integer tiempoDeRecorrido(CalculadorDeDistancia calculadorDeDistancia)
    {
        return CalculadorDeDistancia.tiempoDeUnaDistancia(this.direccionActual,this.direccionDestino);
    };
    public void controlarTiempo(ControladorDeTiempo controladorDeTiempo)
    {
        controladorDeTiempo.temporizador(duracionEstimada);
    }

}
