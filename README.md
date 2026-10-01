# Simulador de Peaje

Aplicacion de consola en Java que simula una estacion de peaje con tres cabinas trabajando de forma concurrente.

## Funcionamiento

- Las cabinas se llaman Cabina Ruiz, Cabina 2 y Cabina 3.
- Cada cabina atiende 10 vehiculos, para un total de 30.
- Cada cobro tarda entre 500 y 1500 milisegundos.
- Por cada vehiculo se suman $50 a la variable totalRecaudadoGlobal.
- El programa utiliza join() para esperar a que terminen los tres hilos.
- Al finalizar, muestra los vehiculos atendidos por cada cabina y el total recaudado.

## Conceptos utilizados

- Interfaz Runnable.
- Creacion e inicio de hilos con Thread y start().
- Simulacion de tiempo con Thread.sleep().
- Espera de los hilos con join().
- Variable estatica compartida.

## Ejecucion

Se necesita un JDK instalado.

1. Abrir SimuladorPeaje.java en Apache NetBeans dentro de un proyecto Java.
2. Ejecutar el archivo con Shift + F6.
3. Consultar los resultados en la ventana de salida.

## Observacion

Por indicacion de la actividad, la variable compartida se actualiza sin mecanismos de sincronizacion. Esto puede ocasionar una condicion de carrera y perder incrementos, por lo que el total mostrado no siempre esta garantizado en $1500.
