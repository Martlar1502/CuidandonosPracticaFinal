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
  * Para los transeuntes y cuidadores, decidimos modelar a ambos como una clase Persona, la otra opción era crear una clase abstracta Persona y que de esta clase hereden Transeuntes y Cuidadores, pero cuando una persona hace una transición de transeunte a cuidador (o viceversa) sería necesario crear un nuevo objeto, pero como la persona es la misma no le encontramos sentido.
  * Para las distintas formas de reaccionar frente a un incidente utilizamos el patrón Strategy, porque la reacción es única pero las implementaciones de cada una de ellas es distinta.
  * Para los estados del recorrido decidimos utilizar el patrón State, porque el estado varía durante el recorrido y por ejemplo el método envirNotificacion() tiene un comportamiento diferente dependiente del estado.
--------------------------------------------------------------------------------------------------
Punto 2.-
![image](https://github.com/JassonMRo/CuidandonosPracticaFinal/assets/83483424/ab032a3e-a6b5-48fe-a824-5566116660a5)

Lo pensamos a este nuevo requerimiento (destino con varias paradas) como una composición de muchos recorridos, y para las particularidades que presenta creamos una nueva clase abstracta porque hay una nueva funcionalidad a incorporar (no se nos ocurrió otra forma mejor, por eso la herencia a pesar que sabemos que es lo ultimo a considerar).

**Aclaración: viendo este nuevo requerimiento, nos damos cuenta de que estaría bueno incorporar una interfaz CalculadorDeDemora, para que no sea un problema las distintas formas que pueden prosentarse sobre este item.

