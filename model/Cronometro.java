package model;

public class Cronometro extends Thread {
    private String nombre;
    private int duracion;
    private static final Object lock = new Object();

    public Cronometro(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    @Override
    public void run() {
        for (int i = 1; i <= duracion; i++) {
            synchronized (lock) {
                System.out.println(nombre + " -> " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(nombre + " interrumpido.");
                return;
            }
        }
        System.out.println(nombre + " finalizado.");
    }
}
