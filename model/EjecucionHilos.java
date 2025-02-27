package model;

public class EjecucionHilos {
    public void iniciar() {
        Cronometro cronoAlfa = new Cronometro("CronoAlfa", 21);
        Cronometro cronoBravo = new Cronometro("CronoBravo", 15);
        Cronometro cronoCharlie = new Cronometro("CronoCharlie", 12);
        Cronometro cronoDelta = new Cronometro("CronoDelta", 6);
        Cronometro cronoEcho = new Cronometro("CronoEcho", 11);
        Cronometro cronoFoxtrot = new Cronometro("CronoFoxtrot", 4);
        Cronometro cronoGolf = new Cronometro("CronoGolf", 7);

        cronoAlfa.start();
        cronoBravo.start();
        cronoCharlie.start();
        cronoDelta.start();
        cronoEcho.start();
        cronoFoxtrot.start();
        cronoGolf.start();

        esperarFinalizacion(cronoAlfa, cronoCharlie, cronoFoxtrot, cronoGolf);
    }

    private void ejecutarExclusivo(Cronometro crono, int segundos) {
        crono.start();
        if (segundos > 0) {
            try {
                Thread.sleep(segundos * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            crono.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void esperarFinalizacion(Cronometro... cronos) {
        for (Cronometro crono : cronos) {
            try {
                crono.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
