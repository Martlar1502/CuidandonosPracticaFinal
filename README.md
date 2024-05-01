# CuidandonosPracticaFinal
DDS 2024

[Práctica entregable] Cuidándonos - Tarea de a pares
Apertura: jueves, 11 de abril de 2024, 00:00
Cierre: miércoles, 1 de mayo de 2024, 19:00

Dado el enunciado de final titulado "Cuidándonos", cuya fecha data el 27/02/2019 (lo encontrarán dentro del link "Finales & clases de consulta" que está dentro de los "Links oficiales de la Cátedra"), deberán resolver de a pares el punto de Modelado de Dominio (punto 1 y punto 2 de la sección Modelo de Dominio). 

Forma de entrega:

Se espera que se envíe un link a un repositorio público que contenga el Diagrama de clases propuesto y todo lo que se considere necesario/lo que solicite el dominio. 
Ambos integrantes del par deberán entregar la tarea, mencionando en el readme quiénes son los integrantes.
-----------------------------------------------------------------------------------------------
Integrantes:
 - Martin Gonzalo Larrart
 - Jasson A. Morales Rodriguez

-------------------------------------------------------------------------------------------------
Punto 1.- 
En el archivo DDC_Cuidandonos.mdj encontraran e diagrama del punto 1
  * Para los transeuntes y cuidadores, decidimos modelar a ambos como una clase Persona, la otra opción era crear una clase abstracta Persona y que de esta clase hereden Transeuntes y Cuidadores, pero cuando una persona hace una transición de transeunte a cuidador (o viceversa) sería necesario crear un nuevo objeto, pero como la persona es la misma no le encontramos sentido.
  * Para las distintas formas de reaccionar frente a un incidente utilizamos el patrón Strategy, porque la reacción es única pero las implementaciones de cada una de ellas es distinta.
  * Para los estados del recorrido decidimos utilizar el patrón State, porque el estado varía durante el recorrido y por ejemplo el método envirNotificacion() tiene un comportamiento diferente dependiente del estado.
--------------------------------------------------------------------------------------------------
Punto 2.-

En el archivo DDC_CuidandonosPunto2.mdj encotraran el diagrama con el nuevo requerimiento incluido, ademas en la carpeta CuidandonosClasesPunto2 se encuentran las clases en Java, cabe destacar que solo se encuntran desarrolladas las clases pedidas en el punto 2, se encuntran especificamente en :

![image](https://github.com/Martlar1502/CuidandonosPracticaFinal/assets/129910860/a4921913-8e6d-4ecd-846a-d715d85d7331)

Lo pensamos a este nuevo requerimiento (destino con varias paradas) como una composición de muchos recorridos, y para las particularidades que presenta creamos una nueva clase abstracta porque hay una nueva funcionalidad a incorporar.

Cálculo de Demora Aproximado:

En un recorrido simple el tiempo de recorrido se calcula usando la funcion tiempoDeUnaDistancia de la CalculadoraDeDistancia, la cual saca la informacion de la API de Google:

    public Integer tiempoDeRecorrido(CalculadorDeDistancia calculadorDeDistancia)
    {
        return CalculadorDeDistancia.tiempoDeUnaDistancia(this.direccionActual,this.direccionDestino);
    };

En un recorrido con paradas se tiene una lista de recorridos y se delega el calculo del tiempo del recorrido en su respectivo ControlEnParada,

	public class RecorridoConParadas extends Recorrido{
	
	    private List<Recorrido> recorridos;
	    private ControlEnParada controlEnParada;
	
	    @Override
	    public Integer tiempoDeRecorrido(CalculadorDeDistancia calculadorDeDistancia) {
	        return controlEnParada.tiempoDeRecorrido(calculadorDeDistancia,this.recorridos);
	    }
	}

 El cual es una interface:
 
	 public interface ControlEnParada {
	    public Integer tiempoDeRecorrido(CalculadorDeDistancia calculadorDeDistancia, List<Recorrido> recorridos);
	
	}

 Si el recorrido con paradas es SinDemora se aplica el metodo tiempoDeRecorrido a cada recorrido de la lista y se devuelve la suma de todos esos tiempos de recorrido:
 
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

Si el recorrido con paradas en ConDemora, se tiene un listado de todas las demoras en cada parada, se aplica el metodo tiempoDeRecorrido a cada recorrido de la lista, se suma esa cantidad y luego se le suma el tiempo de demora en cada parada.

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
