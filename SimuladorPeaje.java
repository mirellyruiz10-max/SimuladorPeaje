import java.util.Random;

class CabinaPeaje implements Runnable {
    public static final String PRIMER_APELLIDO = "Ruiz";

    public static int totalRecaudadoGlobal = 0;

    private final String nombre;
    private final int vehiculosPorAtender;
    private int vehiculosAtendidos;
    private final Random aleatorio = new Random();

    public CabinaPeaje(String nombre, int vehiculosPorAtender) {
        this.nombre = nombre;
        this.vehiculosPorAtender = vehiculosPorAtender;
        this.vehiculosAtendidos = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < vehiculosPorAtender; i++) {
            try {
                int tiempoCobro = aleatorio.nextInt(1001) + 500;
                Thread.sleep(tiempoCobro);

                vehiculosAtendidos++;
                totalRecaudadoGlobal += 50;

                System.out.println(nombre + " atendio un vehiculo. Total de esta cabina: "
                        + vehiculosAtendidos + " | Cobro: $50");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " fue interrumpida.");
                return;
            }
        }
    }

    public int getVehiculosAtendidos() {
        return vehiculosAtendidos;
    }

    public String getNombre() {
        return nombre;
    }
}

public class SimuladorPeaje {
    public static void main(String[] args) {
        CabinaPeaje cabina1 = new CabinaPeaje("Cabina " + CabinaPeaje.PRIMER_APELLIDO, 10);
        CabinaPeaje cabina2 = new CabinaPeaje("Cabina 2", 10);
        CabinaPeaje cabina3 = new CabinaPeaje("Cabina 3", 10);

        Thread hilo1 = new Thread(cabina1);
        Thread hilo2 = new Thread(cabina2);
        Thread hilo3 = new Thread(cabina3);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El programa principal fue interrumpido.");
            return;
        }

        System.out.println(" REPORTE FINAL ");
        System.out.println(cabina1.getNombre() + ": " + cabina1.getVehiculosAtendidos() + " vehiculos");
        System.out.println(cabina2.getNombre() + ": " + cabina2.getVehiculosAtendidos() + " vehiculos");
        System.out.println(cabina3.getNombre() + ": " + cabina3.getVehiculosAtendidos() + " vehiculos");
        System.out.println("Total de vehiculos: " + (cabina1.getVehiculosAtendidos()
                + cabina2.getVehiculosAtendidos() + cabina3.getVehiculosAtendidos()));
        System.out.println("Total recaudado global: $" + CabinaPeaje.totalRecaudadoGlobal);
    }
}
